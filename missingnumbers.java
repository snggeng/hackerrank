import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
        Source: https://www.hackerrank.com/challenges/missing-numbers

        Numeros, the Artist, had two lists A and B, such that B was a
        permutation of A. Numeros was very proud of these lists.
        Unfortunately, while transporting them from one exhibition to another,
        some numbers were left out of A. Can you find the missing numbers?

        Sample Input
        10                                                  // size of list 1
        203 204 205 206 207 208 203 204 205 206             // list 1
        13                                                  // size of list 2
        203 204 204 205 206 207 205 208 203 206 205 206 204 // list 2

        Sample Output
        204 205 206 // ascending order
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        // TreeSet because we want to sort in ascending order
        TreeSet<Integer> hs = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        int n = in.nextInt();
        for (int i = 0; i < n; i ++) {
            int key = in.nextInt();
            // to check later
            hs.add(key);
            if (map.get(key) != null) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int m = in.nextInt();
        // check if number is less
        for (int i = 0; i < m; i ++) {
            int key = in.nextInt();
            if (map.get(key) != null) {
                map.put(key, map.get(key) - 1);
            } else {
                map.put(key, 1);
            }
        }
        // print out keys with non-zero values
        int count = 1;
        for (int key : hs) {
            if (map.get(key) != 0) {
                sb.append(key + " ");

            }
        }
        sb.deleteCharAt(sb.length()-1); // remove " " at the end
        System.out.println(sb);
    }
}
