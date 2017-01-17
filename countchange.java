import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /*  Source: https://www.hackerrank.com/challenges/coin-change
            Keywords: Dynamic Programming

            Given a value N, if we want to make change for N cents,
            and we have infinite supply of each of C = {C1, C2, ... Cm}
            valued coins, how many ways can we make the change?
            The order of coins doesn’t matter.

                            table (N)
               0  1  2  3  4  5  6  7  8  9  10
             0 1  0  0  0  0  0  0  0  0  0  0
             1 1  1  1  1  1  1  1  1  1  1  1
   coins(M)  2 1  1  2  2  3  3  4  4  5  5  6
             3 1  1  2  3  4  5  6  8  10 11 14
             4 1  1  2  3  5  6  8  11 15 17 22

        Time complexity of this function: O(mn)
        Space Complexity of this function: O(n)

        table[i] will be storing the number of solutions
        for value i. We need n+1 rows as the table is
        constructed in bottom up manner using the base
        case (n = 0)

        */

        Scanner sc=new Scanner(System.in);
        int N,M;
        N=sc.nextInt();
        M=sc.nextInt();

        int coins[]=new int[M+1]; // M+1 for consistency of index values
        for(int i=1;i<M+1;i++)
            coins[i]=sc.nextInt();

        long table[]=new long[N+1];

        table[0]=1; // base case (as shown in table above where table[0] = 1)

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for(int i = 1; i < M+1; i++) {
            for(int j = coins[i]; j < N+1; j++) {
                table[j] = table[j]+ table[j-coins[i]];
            }
        }
        System.out.println(table[N]);
    }
}
