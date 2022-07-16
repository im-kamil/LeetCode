class Solution {
    int[][][] dp;
    int M = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        for (int[][] entry : dp) for (int [] row : entry) Arrays.fill(row,-1);

        return dfs(m,n,startRow,startColumn, maxMove);
    }


    public int dfs(int m,int n, int i, int j, int maxMove){

        if (i < 0 || j < 0 || i >= m || j >= n){
            return 1;
        }

        if (maxMove == 0) return 0;

        if (dp[i][j][maxMove] != -1){
            return dp[i][j][maxMove];
        }

        int[] iIter = new int[]{-1,1,0,0};
        int[] jIter = new int[]{0,0,-1,1};

        int ans = 0;
        for (int k = 0; k < 4; k++){
            ans = (ans + dfs(m,n, i + iIter[k], j + jIter[k], maxMove-1)) % M;
        }

        dp[i][j][maxMove] = ans;
        return ans;
    }
}