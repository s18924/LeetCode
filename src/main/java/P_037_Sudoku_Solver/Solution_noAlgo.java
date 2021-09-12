package P_037_Sudoku_Solver;


import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Solution_noAlgo {
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
        char[][] board2 = new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};


        double time = System.currentTimeMillis();
        new Solution_noAlgo().solveSudoku(board);
        new Solution_noAlgo().solveSudoku(board2);

        System.out.println(System.currentTimeMillis() - time);
    }

    public void solveSudoku(char[][] board) {

        boolean isSudokuSolved = true;
        boolean hasSomethingChanged = false;

        do {

            hasSomethingChanged = false;

            for (int i = 0; i < board.length; i++) { //For each empty cell we are looking for answer checking column, row and box
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') { //only run searching method if cell is empty
                        int number = findCorrectNumber(board, i, j); //method will return -1 if answer is not found
                        if (number != -1) {
/*                        System.out.println("Before was " + board[i][j]);
                        System.out.println("Found " + number + " for " + i + " " + j);*/
                            board[i][j] = (char) ('0' + number);
                            hasSomethingChanged = true;
                        }
                    }
                }
            }

            isSudokuSolved = isSudokuSolved(board);

          //  printSudoku(board);

            if(!hasSomethingChanged)
                break;


        } while (!isSudokuSolved);

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

    private boolean isSudokuSolved(@NotNull char[][] board){
        boolean isSudokuSolved = true;
        for (int i = 0; i < board.length; i++) { // check if any empty space is left, if so, mark sudoku as not solved
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    isSudokuSolved = false;
                    break;
                }
            }
            if (!isSudokuSolved)
                break;
        }
        return isSudokuSolved;
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

    private int findCorrectNumber(char[][] board, int i, int j) {
        // System.out.println("For: " + i + " " + j + " : ");

        //Would be more time-efficient with boolean table, but for readibility we are using set
        Set<Integer> availableNumbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9)); //All available numbers are stored here, every time we meet one, we will delete if from posiible solutions

        for (int k = 0; k < board.length; k++) {
            //Column
            if (!(board[k][j] == '.')) {
                availableNumbers.remove(board[k][j] - '0');
                //  System.out.println("Removing " + ((int)board[k][j] - '0') + " was on: " + k + " " + j + availableNumbers);
            }
            //Row

            if (!(board[i][k] == '.')) {
                availableNumbers.remove(board[i][k] - '0');
                //   System.out.println("Removing " + ((int)board[i][k] - '0') + " was on: " + i + " " + k + availableNumbers);
            }
        }


        int boxColumn = (i / 3) * 3; //calculating box
        int boxRow = (j / 3) * 3;
        for (int k = boxColumn; k < boxColumn + 3; k++) {
            for (int l = boxRow; l < boxRow + 3; l++) {

                if (!(board[k][l] == '.')) {
                    availableNumbers.remove(board[k][l] - '0');
                    //    System.out.println("Removing " + ((int)board[k][l] - '0') + " was on: " + k + " " + l + availableNumbers);
                }
            }
        }

        //     System.out.println("For: " + i + " " + j + " : " + availableNumbers);

        if (availableNumbers.size() == 1)
            return (int) availableNumbers.toArray()[0];
        else return -1;
    }
}
