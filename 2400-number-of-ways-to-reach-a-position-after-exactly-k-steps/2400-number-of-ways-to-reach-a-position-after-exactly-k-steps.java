class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
         int[] dp = new int[3002];
    startPos += 1000;
    endPos += 1000;
    dp[startPos] = 1;
    for(int x = 0; x < k; x++){
        int pre = 0;
        for(int i = 0; i < 3001; i++){
            int npre = dp[i];
            dp[i] = (pre + dp[i+1]) % 1_000_000_007;
            pre = npre;
        }
    }
    return dp[endPos];
    }
}