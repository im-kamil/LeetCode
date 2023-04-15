class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int numPiles = piles.size();
        
        int[][] dp = new int[numPiles+1][k+1];
        
        for(int i=1; i<=numPiles; i++){
            for(int j=1; j<=k; j++){
                dp[i][j] = dp[i-1][j]; 
                List<Integer> currPile = piles.get(i-1);
                int coinSum = 0;
                for(int l=0; l < Math.min(currPile.size(), j); l++){
                    coinSum += currPile.get(l);
                    dp[i][j] = Math.max(dp[i][j], coinSum + dp[i-1][j - l - 1]); 
                }
            }
        }
        
        return dp[numPiles][k]; 
    }
}