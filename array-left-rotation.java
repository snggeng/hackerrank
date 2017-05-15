import java.io.*;
import java.util.*;

public class Solution {
    /*
    Source:
    A left rotation operation on an array of size  shifts each of the array's elements  unit to the left.
    For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5],
    then the array would become [3, 4, 5, 2, 1].

    Given an array of n integers and a number, d, perform d left rotations on the array.
    Then print the updated array as a single line of space-separated integers.
    */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        int[] array = new int[n];

        for(int i=0; i < n; i++) {
            array[(i+n-r)%n] = in.nextInt(); // moves forward the index by n-r
        }
        for (int i=0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
