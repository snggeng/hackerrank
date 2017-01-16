import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Source: https://www.hackerrank.com/challenges/utopian-tree
The Utopian Tree goes through 2 cycles of growth every year.
Each spring, it doubles in height. Each summer, its height increases by 1 meter.

Laura plants a Utopian Tree sapling with a height of 1 meter at the onset
of spring. How tall will her tree be after N growth cycles?

Original height: 1

// even cases
year 1 (2 cycles) : 1*2+1 = 3
year 2 (4 cycles) : 3*2+1 = 7
year 3 (6 cycles) : 7*2+1 = 15
year 4 (8 cycles) : 15*2+1 = 31
year 5 (10 cycles) : 31*2+1 = 63

do some math...

2   4    6     8    10  // value of n

3   7   15    31    63  // -- (1) or height
  4    8    16   32     // -- (2)
     4    8    16
        4    8
           4

every year you add 2^(n/2) in common difference
from (2), height is 2 * 2^(n/2) - 1

even: 2[2^(n/2) - 1] + 1

1   3    5     7     9 // value of n

2   6   14    30    62 // -- (3) or height
  4   8    16    32    // -- (4)
    4    8    16
       4    8
          4

every year you add 2^((n+1)/2) in common difference
from (4), height is 2 * 2^((n+1)/2) - 2

odd: 2[2^(n/2 + 1) - 1] // in java division of int rounds down
                        // so n/2 + 1 == ((n+1)/2) for odd numbers

*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int height = 0;
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        int n = in.nextInt();
            if(n%2 == 0)
                height = (int) Math.pow(2, n/2)*2 - 1;
            else
                height = (int) (Math.pow(2, n/2 + 1) - 1)*2;

            System.out.println(height);
        }
    }
}
