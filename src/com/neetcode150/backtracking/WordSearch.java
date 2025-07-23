package com.neetcode150.backtracking;

/**
 * Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.
 * For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells.
 * The same cell may not be used more than once in a word.
 * Input:
 * board = [
 *   ["A","B","C","D"],
 *   ["S","A","A","T"],
 *   ["A","C","A","E"]
 * ],
 * word = "CAT"
 *
 * Output: true
 * */
public class WordSearch {
    private int ROWS, COLS;

    public static void main(String[] args){
        char[][] board = {{'A','B','C','D'},{'S','A','A','T'},{'A','C','A','E'}};
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(board,"CAT"));
    }

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
                board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r, c + 1, i + 1) ||
                dfs(board, word, r, c - 1, i + 1);
        board[r][c] = word.charAt(i);
        return res;
    }
}
