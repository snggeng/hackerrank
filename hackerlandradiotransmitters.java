import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
        Source: https://www.hackerrank.com/challenges/hackerland-radio-transmitters
        Given a one-dimensional city with N houses, install transmitters that cover K houses
        such that all houses specified are covered.

        Sample Input 0
        5 1             // N=5, K=1
        1 2 3 4 5

        Sample Output 0
        2               // Since in order to cover all 5 houses,
                        // we need to put one transmitter at 2, and 4 only
                        // 1-*2*-3-*4*-5  *indicates transmitter
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int i,j,t=0;
        // sorting ** insertion sort **
        for( i=0;i<n;i++) {
                int key=x[i];
                for( j=i-1;j>=0 && x[j] > key;j--) {
                     x[j+1]=x[j];
                }
                x[j+1]=key;
        }
        int res=0;
        for(i=0;i<n-1;i++) {
                for(j=i+1; j<n && x[j]<=x[i]+k; j++);
                j--;
                t++;
                res=x[j]+k;
                for(j=j; j<n && x[j]<=res; j++);
                i=--j;
        }
        // checking boundary conditions
        if(i<n)
        if(res <x[i]) t++;
        System.out.println(t);
    }
}
