/*
51. N-Queens
Solved
Hard
Topics
premium lock icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
*/
import java.util.*;
public class nqueen {
    public static void main(String[] args) {
        nqueen sol = new nqueen();
        int n = 4; // Change this value to test for different board sizes
        List<List<String>> result = sol.solveNQueens(n);
        
        // Print the total number of solutions found
        System.out.println("Total solutions for " + n + "-Queens: " + result.size());
        System.out.println();

        // Print each board configuration
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            for (String row : result.get(i)) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        nQueen(board, 0, res);
        return res;
    }

    private void nQueen(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueen(board, row + 1, res);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Left-upwards diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Right-upwards diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
