import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /*
           Source: https://www.hackerrank.com/challenges/equal
           Keywords: DP, Greedy Algorithm
           Redistribute chocolates equally. For every operation, you can choose one of
           your colleagues and can do one of the three things.

           1. Give one chocolate to every colleague other than chosen one.
           2. Give two chocolates to every colleague other than chosen one.
           3. Give five chocolates to every colleague other than chosen one.

           Calculate minimum number of such operations needed to ensure that every
           colleague has the same number of chocolates.

           Solve:
           find min，max and then difference that you need to make up i.e. intern[i]-f(min)

           difference       no. of choc
           0 0 1 5          2 2 3 7
           0 0 0 5 -1       3 3 3 8 + 1
           0 0 0 0 -5       8 8 8 8 + 5

           possible increments: 0, 1, 2, 5

           greedy algorithm: k = x/5 + (x%5)/2 + (x%5)%2 // to get min no. of operations to 0
           f(A) <= f(min) < f(min-5)

        */

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a = 0; a < t; a++) {
            int n = in.nextInt();
            List<Integer> intern = new ArrayList<>();
            for (int b = 0; b < n; b++) {
                intern.add(in.nextInt());
            }
            System.out.println(equalize(intern));
        }
    }

     public static int equalize(List<Integer> starting) {
        int min = Collections.min(starting);

        int upperRange = (min >= 4) ? 4 : min; // get the least number of iterations based on min
        int minOps = Integer.MAX_VALUE;
        for (int i = 0; i <= upperRange; i++) {
            int totalOps = 0;
            // we want to check for f(A) where A={min, min-1, min-2, min-3, min-4}
            // since although we minimise the difference to min=0,
            // it might be faster to get min=-1 or min=-2 i.e. edge cases
            int newMin = min - i;
            for (int chocos : starting) {
                totalOps += opsToZero(chocos - newMin);
            }
            // get the solution with least operations in f(A)
            if (totalOps < minOps) {
                minOps = totalOps;
            }
        }

        return minOps;
    }

    public static int opsToZero(int num) {
        int count = 0;
        count += num / 5; // if num >= 5, 1 else 0
        num = num % 5; // 0, 1, 2, 3 or 4
        count += num / 2; // if num >= 2, 1 else 0
        num = num % 2; // 0 or 1
        count += num;
        return count;

    }
}
