import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Source: https://www.hackerrank.com/challenges/sherlock-and-the-beast
Keywords: Greedy Algorithm, Linear Combination

A Decent Number N, has the following properties:

* Its digits can only be 3's and/or 5's.
* The number of 3's it contains is divisible by 5.
* The number of 5's it contains is divisible by 3.
* If there are more than one such number, we pick the largest one.

N is the number of digits in the key
Number of '5's need to be divisible by 3 while number of '3's need to be divisble by 5.
*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            // divisible by 3 is a base
            for(int i = n; i >= 0; i--) {   // no. of '5's is important since we want the biggest value
                if(i%3==0 && (n-i)%5==0) {
                    int j=0;
                    for(j=0;j<i;j++) sb.append("5");
                    for(int k=j;k<n;k++) sb.append("3");
                    break;
                }
            }
            if(sb.length() == 0)
                System.out.println("-1");
            else
                System.out.println(sb);
        }
    }
}
