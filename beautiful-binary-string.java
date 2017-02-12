import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
    Source: https://www.hackerrank.com/challenges/beautiful-binary-string
    Keywords: String manipulation

    Alice has a binary string, B, of length n. She thinks a binary string is beautiful
    if and only if it doesn't contain the substring "010". Return the number of changes
    needed to beautify the string.
*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        String binary =  in.nextLine();
        int changes = 0;
        int start=0;


        while(true){
            int foundIndex = binary.indexOf("010",start); // compare string in sets of 3s
            if(foundIndex==-1){break;}
            start = foundIndex+3; //update index to begin comparison for string
            changes++;
        }
       System.out.println(changes);
    }
}
