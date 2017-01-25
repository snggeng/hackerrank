import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
        Source: https://www.hackerrank.com/challenges/lonely-integer
        Keywords: Bitwise, Caching

        Every element in A occurs exactly twice except for one unique element.
        Given A, find and print the unique element.
    */
     private static int lonelyInteger(int[] a) {
      /* SOLUTION 1: Caching
        int lonely = 0;
        if (a.length == 1) return a[0];
        // map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            if (map.get(key) != null) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }
        for (int j = 0; j < a.length; j++) {
            int key = a[j];
            if (map.get(key) == 1) {
                lonely = key;
            }
        }
        return lonely;
     */
       /*   SOLUTION 2: Bitwise XOR
            XOR(^) is a binary operation called exclusive OR and works as

            1^0 = 1
            0^1 = 1
            0^0 = 0
            1^1 = 0

            Sample Input
            5
            7 6 7 6 2

            Sample Output
            2

            Explanation:
            1) 0 ^ 7 => 111 --(1)
            2) (1) ^ 6 => 111 ^ 110 => 001 --(2)
            3) (2) ^ 7 => 001 ^ 111 => 110 --(3)
            4) (3) ^ 6 => 110 ^ 110 => 000 --(4) // see how we cancelled out?
            5) (4) ^ 2 => 000 ^ 010 => 010 //this is our answer
       */
        int result = 0;

        for(int i : a) {
            result = result ^ i; //When you XOR two bits together, matching values cancel each other out
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}
