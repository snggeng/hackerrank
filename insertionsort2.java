import java.io.*;
import java.util.*;

public class Solution {
    /*
        Source: https://www.hackerrank.com/challenges/insertionsort2
        Insertion sort part 2... print it out
    */
    public static void insertionSortPart2(int[] ar) {
           for(int j = 1; j < ar.length; j++) {
            int key = ar[j];
            int i = j - 1;
            while (i > (-1) && ar[i] > key) {
                ar[i + 1] = ar[i];
                i--;
            }
            ar[i + 1] = key;
            printArray (ar);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
       }
       insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
