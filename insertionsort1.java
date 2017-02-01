import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
        Source: https://www.hackerrank.com/challenges/insertionsort1
        Keywords: Insertion Sort

        Sample Input (stdin)
        5
        2 4 6 8 3

        Sample Output
        2 4 6 8 8
        2 4 6 6 8
        2 4 4 6 8
        2 3 4 6 8

        Expected Output
        2 4 6 8 8
        2 4 6 6 8
        2 4 4 6 8
        2 3 4 6 8
    */

    public static void insertIntoSorted(int[] ar) {
        int len = ar.length;
        int j, toMoveUp;
        for(int i = 0; i < len; i++){
            toMoveUp = ar[i]; //
            j = i;
            while(j > 0 && ar[j-1] > toMoveUp){
                ar[j] = ar[j-1]; // if greater than toMoveUp, shift left
                j--;
                printArray(ar);
            }
          ar[j]=toMoveUp; // arr[j-1] < toMoveUp
        }
        printArray(ar);
    }


/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
