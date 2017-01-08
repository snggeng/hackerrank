import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  /*
    Given a 2D array of digits, try to find the occurrence of a given 2D pattern of digits. For example, consider the following 2D matrix:

    1234567890
    0987654321
    1111111111
    1111111111
    2222222222
    Assume we need to look for the following 2D pattern:

    876543
    111111
    111111
    
    If we scan through the original array, we observe that the 2D pattern begins at the second row and the third column of the larger grid (the  in the second row and third column of the larger grid is the top-left corner of the pattern we are searching for).

    So, a 2D pattern of  digits is said to be present in a larger grid , if the latter contains a contiguous, rectangular 2D grid of digits matching with the pattern , similar to the example shown above.
  */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            System.out.println(search(G, P) ? "YES" : "NO");
        }
        in.close();
    }

    // iterate search method across grid G for number of test cases
    private static boolean search(String[] G, String[] P) {
        for (int i = 0; i <= G.length - P.length; i++) {
            for (int j = 0; j <= G[0].length() - P[0].length(); j++) {
                if (search(G, P, i , j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // check for pattern using charAt for G and P
    private static boolean search(String[] G, String[] P, int i, int j) {
        for (int k = 0; k < P.length; k++) {
            for (int l =0; l < P[0].length(); l++) {
                if (G[i+k].charAt(j+l) != P[k].charAt(l)) {
                    return false;
                }
            }
        }
        return true;
    }
}
