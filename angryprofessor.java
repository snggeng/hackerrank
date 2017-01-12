import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
/*
Source: https://www.hackerrank.com/challenges/angry-professor
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int count = 0;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            // check if student arrived on time
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                if (a[a_i] <= 0) k--;
            }
            // check if class is canceled
            if (k <= 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
