class Solution {
     public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
         int INF = (int)1e9;
        int[][][] dp = new int[target+1][m+1][n+1];
		
		// Initialize dp array
        for (int i = 0; i <= target; i++)
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        Arrays.fill(dp[0][0], 0);
        
        for (int k = 1; k <= target; k++)
            for (int i = 1; i <= m; i++) {
                if (houses[i-1] != 0) { // the current house is painted
                    int curColor = houses[i-1];
                    for (int c2 = 1; c2 <= n; c2++) { // iterate through previous color
                        dp[k][i][curColor] = Math.min(dp[k][i][curColor], 
                                               dp[k - (c2 == curColor ? 0 : 1)][i-1][c2]);
                    }
                }
                else { // the current house is not painted
                    for (int c1 = 1; c1 <= n; c1++) {  // iterate through current color
                        for (int c2 = 1; c2 <= n; c2++) {  // iterate through previous color
                           dp[k][i][c1] = Math.min(dp[k][i][c1], 
                                         dp[k - (c2 == c1 ? 0 : 1)][i-1][c2] + cost[i-1][c1-1]);
                        }  
                    }
                }
           }
        
        // find the minimum cost in dp[target][m][*]
        int res = INF;
        for (int c = 1; c <= n; c++)
            res = Math.min(res, dp[target][m][c]);
        return res == INF ? -1 : res;
    }
}