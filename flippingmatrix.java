import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
    Source: https://www.hackerrank.com/challenges/flipping-the-matrix
    Keywords: matrix, constructive algorithm, greedy algorithm

    Sean invented a game involving a 2n x 2n matrix where each cell
    of the matrix contains an integer. He can reverse any of its rows
    or columns any number of times, and the goal of the game is to
    maximize the sum of the elements in the  submatrix located in the
    upper-left corner of the 2n x 2n matrix (i.e., its upper-left quadrant).

    Sample Input
        0   1   2   3    // column
     0  112 42  83  119
     1  56  125 56  49
     2  15  78  101 43
     3  62  98  114 108
  //row

    Sample Output
    144

    Reverse column 2
    Reverse row 0
    119 + 114 + 56 + 125 = 144
*/

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();

        for(int i = 0; i < queries; i++){
            int n = in.nextInt();
            int[][] board = new int[2*n][2*n];
            for (int j = 0; j < 2 * n; j++){
                for (int k = 0; k < 2 * n; k++){
                    board[j][k] = in.nextInt();
                }
            }
            System.out.println(maxUpperLeftQuadrant(board));
        }
    }
    public static int maxVal(int[][] board, int row, int col){
        int maxVal = board[row][col];

        int altRow = (board.length - 1) - row;
        int altCol = (board.length - 1) - col;

        maxVal = Math.max(maxVal, board[altRow][col]); // flip row
        maxVal = Math.max(maxVal, board[row][altCol]); // flip col
        maxVal = Math.max(maxVal, board[altRow][altCol]);// flip both

        return maxVal;
    }

    /** Assumes board is a square matrix.*/
    public static int maxUpperLeftQuadrant(int[][] board){
        int sum = 0;

        for (int row = 0; row < board.length / 2; row++){
            for (int col = 0; col < board.length / 2; col++){
                sum += maxVal(board, row, col);
            }
        }
        return sum;
    }
}
