class Solution {
    public void solve(char[][] board) {
         if(board.length == 0)
            return;
          for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1){
                    dfs(i,j,board);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='-'){
                   board[i][j]='O';
                }
                else{
                    board[i][j]='X'; 
                }
            }
        }

    }

    private void dfs(int i, int j, char[][] board) {
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || board[i][j]!='O'){
            return;
        }
        board[i][j]='-';

        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}