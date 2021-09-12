package P_037_Sudoku_Solver;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new Solution().solveSudoku(board);

        System.out.println("123");
        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

        public boolean solve(char[][] board) {
     //   printSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] ==  '.'){
                    for (int k = 1; k <=9  ; k++) {
                        if (canBeInserted(board,i,j, (char) ('0'+k))) {

                            board[i][j] = (char) ('0' + k);
                            if(solve(board))
                                return true;
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canBeInserted(char[][] board, int col, int row, char number) {
        //checks if number will not break sudoku rules while being insterted into col/row cell
        //returns false if will break, and true if not

        for (int k = 0; k < board.length; k++) {
            if (board[k][row] == number)             //Column
                return false;

            if (board[col][k] == number)              //Row
                return false;
        }

        int boxColumn = (col / 3) * 3; //calculating box
        int boxRow = (row / 3) * 3;
        for (int k = boxColumn; k < boxColumn + 3; k++)
            for (int l = boxRow; l < boxRow + 3; l++)
                if (board[k][l] == number)
                    return false;

        return true;
    }

    private void printSudoku(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println();
    }
}
