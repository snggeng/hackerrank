import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
/*
Source: https://www.hackerrank.com/challenges/extra-long-factorials
Using BigIntegers in Java to calculate extra long factorials
*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // calculate factorial of n: n * (n-1) * (n-2) * ... * 3 * 2 * 1
        // use BigInteger since long is insufficient

        // initialize BigInteger
        BigInteger factorial = BigInteger.valueOf(n);

        // use methods in the BigInteger library
        for (int i = (n - 1); i > 0; i--) {
            factorial = factorial.multiply((BigInteger.valueOf(i)));
        }

        System.out.println(factorial);
    }
}
