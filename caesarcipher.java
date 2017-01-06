import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
    Source: https://www.hackerrank.com/challenges/caesar-cipher-1
    Caesar Cipher, also known as Shift Cipher: encryption by shifting characters in a string by k values
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();

        k = k % 26; // to account for chars that overflow
        // i.e. 'z' has relative pos of 25 (0-25)
        // so shifting 5 values = 25+5 but you need your value to be within < 26
        // 30 % 26 = 4 which is 'e'
        System.out.println(encrypt(s, n, k));
        in.close();
    }

    private static String encrypt(String str, int length, int shift) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < length; i++) {
            c = str.charAt(i);
            // if c is letter ONLY then shift them, else directly add it
            if (Character.isLetter(c)) {
                c = (char) (str.charAt(i) + shift);
                // checking case or range check is important, just if (c > 'z'
                // || c > 'Z') will not work
                if ((Character.isLowerCase(str.charAt(i)) && c > 'z')
                 || (Character.isUpperCase(str.charAt(i)) && c > 'Z'))
                    c = (char) (str.charAt(i) - (26 - shift));
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
