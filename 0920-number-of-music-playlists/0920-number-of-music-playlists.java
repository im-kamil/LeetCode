class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
       int MOD = 1000000007;
    long[][] dp = new long[goal+1][n+1];
    dp[0][0] = 1;
    
    for (int i = 1; i <= goal; i++) {
        for (int j = 1; j <= n; j++) {
            dp[i][j] = (dp[i-1][j-1] * j + dp[i-1][j] * Math.max(j-k, 0)) % MOD;
        }
    }
    
    return (int) dp[goal][n];
    }
}