class Solution {
    // final int MOD = 100000007;
    // Hashmap<String, Integer> map = new Hashmap<>();
     public int numRollsToTarget(int d, int f, int target) {
    //     if(target<n || target>n*k)
    //         return 0;
    //     if(n==1) return (target<=k)? 1:0;
    //     String key = ""+ n+k +target;
    //     if(!map.containsKey(Key)){
    //     int sum = 0;
    //     for(int i =0; i<k; i++){
    //         sum+=numRollsToTarget(n-1,k,target-i);
    //         sum%=MOD;
    //     }
    //         map.put(key, sum);
    //     }
    //     return map.get(key);
    int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1]; 
        dp[0][0] = 1;
		//how many possibility can i dices sum up to j;
        for(int i = 1; i <= d; i++) {
            for(int j = 1; j<= target; j++) {
                if(j > i * f) {
                   continue;         //If j is larger than largest possible sum of i dices, there is no possible ways.    
                } else {                      //watch out below condition, or NPE
                    for(int k = 1; k <= f && k <= j ; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD; 
                    }
                }
            }
        }
        return dp[d][target];
        
    }
}