package P_036_Valid_Sudoku;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));

        System.out.println(new Solution().isValidSudoku(new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[] repeated = new boolean[9]; //We'll be checking all the '9s' on the board, because there mustn't be repeats, it will be cleared after each loop

        //rows checking
        for (char[] chars : board) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '.') //Continue the loop if value is not set
                    continue;
                //By dividing 0 from value at the board (we know there is a value from 0 to 9, as we are skipping all the 'dots' (empty fields) in previous loop) we get index of value, and know if there was such before
                if (repeated[chars[j] - '0' - 1])
                    return false;
                else repeated[chars[j] - '0' - 1] = true;

            }
            repeated = new boolean[9];
        }

        //columns checking
        for (int i = 0; i < board[0].length; i++) { //We are doing the same thing as above, but now for columns
            for (int j = 0; j < board.length; j++) {

                if (board[j][i] == '.')
                    continue;
                if (repeated[board[j][i] - '0' - 1])
                    return false;
                else repeated[board[j][i] - '0' - 1] = true;
            }
            repeated = new boolean[9];
        }

        //box checking
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                for (int k = i; k < i+3 ; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (board[k][l] == '.')
                            continue;
                        if (repeated[board[k][l] - '0' - 1])
                            return false;
                        else repeated[board[k][l] - '0' - 1] = true;
                    }
                }
                repeated = new boolean[9];
            }

        }

        return true;
    }
}

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.


A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true

Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
    The given board contain only digits 1-9 and the character '.'.
    The given board size is always 9x9.




Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Sudoku.
Memory Usage: 39.1 MB, less than 96.20% of Java online submissions for Valid Sudoku.
 */