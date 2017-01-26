import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
/*
    Source: https://www.hackerrank.com/challenges/maximizing-xor
    Keywords: XOR

    Given two integers, L and R, find the maximal value of A xor B, where A and B satisfy the following condition:
    1 <= L <= R < 10^3

    Sample Input
    10
    15

    Sample Output
    7

    Explanation:
    check 10 xor 10, 10 xor 11 ... 15 xor 15 \\ only keep max xor
 */

    static int maxXor(int l, int r) {
        int max = Integer.MIN_VALUE;
        while (l <= r) {
          for (int i = l; i <= r; i++) {
              if (max < (i ^ l)) max = (i ^ l);
          }
          l++;
        }
    return max;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);
    }
}
