import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*  Source: https://www.hackerrank.com/challenges/quicksort3
        Keywords: Quicksort, Lomuto Partitioning, Recursion

        QuickSort In-Place
        Implement a quicksort using the
        Lomuto Partitioning method: using last int as pivot

        The In-place Trick

        1. If an element is lower than the pivot, you should swap it with a
           larger element on the left-side of the sub-array.

        2. Greater elements should remain where they are.

        3. At the end of the partitioning method, the pivot should be swapped
           with the first element of the right partition, consisting of all larger
           elements, of the sub-array.

        4. To ensure that you don't swap a small element with another small
           element, use an index to keep track of the small elements that have
           already been swapped into their "place".
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar, 0, n-1);
    }


    static void quickSort(int[] ar, int start, int end) {
        if(start < end){
            int pivot = partition(ar, start, end);
            printArray(ar);
            quickSort(ar, start, pivot-1);
            quickSort(ar, pivot+1, end);

        }
    }

    static int partition(int[] ar, int start, int end) {
        int pivot = ar[end];
        int i = start;
        for(int j = start; j < end; j++ ){
            if (ar[j] <= pivot){
                int temp = ar[i]; // save current int
                ar[i] = ar[j]; // swap both ints
                ar[j] = temp;
                i++;
            }
        }

        int temp = ar[i]; // i = no. of swapped ints, ar[i] is the largest number in partition
        ar[i] = ar[end]; // swap pivot in place
        ar[end] = temp; // largest number becomes new pivot

        return i;
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
