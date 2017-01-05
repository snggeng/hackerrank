import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /*
        Source: https://www.hackerrank.com/challenges/pangrams

        Reading Pangrams (strings that use all the letters in the alphabet at least once)

        Enter your code here. Read input from STDIN.
        Print output to STDOUT.
        Your class should be named Solution. 
        */
        Scanner scan = new Scanner(System.in);
        String s = "";
        char[] charArray;
        Set<Character> h = new HashSet<Character>();
        // read stdin and add chars into hashset
        while (scan.hasNext()) {
            s = scan.next().toLowerCase(); // lowercase significant since 'a' != 'A'
            charArray = s.toCharArray();
            for (char c : charArray) {
                h.add(c);
            }
        }
        // check if size < 26
        if (h.size() < 26) {
            System.out.println("not pangram");
        } else {
            System.out.println("pangram");
        }
    }
}
