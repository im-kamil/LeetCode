class Solution {
    public int findNumberOfLIS(int[] nums) {
         int dp[]=new int[nums.length];
        int count[]=new int[nums.length];
        dp[0]=1;
        count[0]=1;
        int result=0;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            count[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if(dp[i]==dp[j]+1)
                    {
                        count[i]+=count[j];
                    }
                        
                }
            }
            
        }
        for(int i=0;i<nums.length;i++){
            if(max<dp[i])
            {
                result=count[i];
                max=dp[i];
            }
            else if(max==dp[i])
                result+=count[i];
        }
        return result;
    }
}