class Solution {
    public int totalNQueens(int n) {
        return solve(new boolean[n][n], 0);
    }
    
    public int solve(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (!board[row][i] && isQueenSafe(board, row, i)) {
                board[row][i] = true;
                count = count + solve(board, row + 1);
                board[row][i] = false;
            }
        }
        return count;
    }
    
     public boolean isQueenSafe(boolean[][] board, int row, int col) {
         for (int i = 0; i < board.length; i++) {
             if (board[row][i] || board[i][col]) {
                 return false;
             }
         }
         
         int i = row - 1;
         int j = col - 1;
         while (i >= 0 && j >= 0) {
             if (board[i][j]) {
                 return false;
             }
             i--;
             j--;
         }
    
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}