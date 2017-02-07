import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
        Source: https://www.hackerrank.com/challenges/fibonacci-modified
        Keywords: BigInteger, Fibonacci

        Given the first 2 numbers of a fibonacci sequence, generate a
        fibonacci sequence up till N and print the last number.
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger t1 = BigInteger.valueOf(in.nextInt());
        BigInteger t2 = BigInteger.valueOf(in.nextInt());
        BigInteger t3 = BigInteger.valueOf(0);
        int n = in.nextInt(); // cardinality of set of fibonacci numbers we want

        for (int x=0; x<n-2; x++){
            t3 = (t1.add((t2.multiply(t2)))); // BigInteger is immutable so you need to use java's methods
            t1=t2;                            // for addition and multiplication
            t2=t3;
        }
        System.out.println(t2);
    }
}
