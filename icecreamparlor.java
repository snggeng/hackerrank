import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
        Source: https://www.hackerrank.com/challenges/icecream-parlor
        Given N ice cream flavors that cost C={C1, C2,...Cm}
        find 2 flavors that cost M in total

        Use HashMap for O(n), faster than linear search using many loops
        // can also be solved using binary search with a sorted array

        M = 4
        N = 5
        C = {1, 4, 5, 3, 2} // flavor 1 costs 1, flavor 2 costs 4, and so on

        Store in map: key = M - C, value = flavor no.
        3  : flavor 1
        0  : flavor 2
        -1 : flavor 3
        1  : flavor 4 // see here M = key + C which is what we want
        2  : flavor 5

    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t --> 0) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int m = in.nextInt();
            int n = in.nextInt();
            for(int i = 0; i < n; i++)
            {
                int flavor = in.nextInt();
                if(map.containsKey(flavor))
                {
                    System.out.println((map.get(flavor)) + " " + (i+1));
                } else {
                    map.put(m - flavor, i + 1);
                }
            }
        }
    }
}
