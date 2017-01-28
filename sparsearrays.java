import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
        Source: https://www.hackerrank.com/challenges/sparse-arrays

        There are N strings. Each string's length is no more than 20 characters.
        There are also Q queries. For each query, you are given a string,
        and you need to find out how many times this string occurred previously.

        Store strings into hashmap and for each query, check if map.containsKey
    */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashMap<String ,Integer> map = new HashMap();
        String s;

        scan.nextLine();
        for(int i = 0; i < n; i++){
            s = scan.nextLine();
            if (map.containsKey(s)){
                map.put(s, map.get(s)+1);
            } else {
                map.put(s, 1);
            }
        }

        int q = scan.nextInt();
        scan.nextLine();

        for(int j = 0; j < q; j++){
            s = scan.nextLine();
            if (map.containsKey(s)){
                System.out.println(map.get(s));
            } else {
               System.out.println(0);
            }
        }
    }
}
