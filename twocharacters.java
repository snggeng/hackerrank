import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
SOLUTION 1: using a matrix
Input: acbab

Matrix begins empty:
  a b c
a
b
c

We begin with the first 'a'. We update the 'a' row and column with that letter as last:
  a b c
a a a a
b a
c a

  a b c
a a a c
b a   c
c c c c

  a b c
a a b c
b b b b
c c b c

  a b c
a a a a
b a b b
c a b c

Finally, here comes the last letter: 'b'. Note that there is already a 'b' in combination c-b, so that alternation won't work:
  a b c
a a b a
b b b b
c a b c

*/


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();

        // initiliaze 2d arrays
        char [][] letters = new char[26][26];
        int [][] values = new int[26][26];
        for(char c : s.toCharArray()) {
            // store index values of chars
            int index = (int)(c - 'a');
            for(int i = 0; i < 26; i++) {
                // for each column
                if(letters[index][i] != c && values[index][i] != -1) {
                    letters[index][i] = c;
                    ++values[index][i];
                } else {
                    values[index][i] = -1;
                }
                // for each row
                if(letters[i][index] != c && values[i][index] != -1) {
                    letters[i][index] = c;
                    ++values[i][index];
                } else {
                    values[i][index] = -1;
                }
            }
        }
        int largestString = 0;
        // iterate through values to check for the largest string
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                if(values[i][j] > largestString) {
                    largestString = values[i][j];
                }
            }
        }
        if(largestString > 1) {
            System.out.println(largestString) ;
        } else {
            System.out.println("0");
        }
    }
}
