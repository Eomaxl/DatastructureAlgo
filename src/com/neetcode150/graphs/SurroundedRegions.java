package com.neetcode150.graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if( board == null || board.length == 0){
            return;
        }
        int rows = board.length, cols = board[0].length;

        for (int i=0 ; i<rows; i++){
            for (int j =0 ; j < cols ; j++) {
                if (( i ==0 || i == rows-1 || j == 0 || j == cols -1) && board[i][j] == 'O'){
                    dfs(board, i , j);
                }
            }
        }

        // revert 'T' to '0'
        for(int i =0; i < rows; i++){
            for(int j = 0; j< cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i <0 || i >=board.length || j <0 || j >=board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'T';
        dfs(board,i-1, j);
        dfs(board,i+1, j);
        dfs(board,i, j-1);
        dfs(board,i, j+1);
    }
}
