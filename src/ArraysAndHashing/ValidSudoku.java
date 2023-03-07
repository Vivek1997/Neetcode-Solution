package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int rows = 9;
        int cols = 9;

        for (int i = 0; i < rows; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.')
                    continue;
                if (rowSet.contains(board[i][j]))
                    return false;
                rowSet.add(board[i][j]);
            }
        }

        for (int i = 0; i < rows; i++) {
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[j][i] == '.')
                    continue;
                if (colSet.contains(board[j][i]))
                    return false;
                colSet.add(board[j][i]);
            }
        }

        for (int i = 0; i < rows; i = i + 3) {
            for (int j = 0; j < cols; j = j + 3) {
                if (!checkBlock(i, j, board))
                    return false;
            }
        }

        return true;
    }

    private boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;
        for (int k = idxI; k < rows; k++) {
            for (int l = idxJ; l < cols; l++) {
                if (board[k][l] == '.') {
                    continue;
                }

                if (blockSet.contains(board[k][l])) {
                    return false;
                }

                blockSet.add(board[k][l]);
            }
        }
        return true;
    }
}
