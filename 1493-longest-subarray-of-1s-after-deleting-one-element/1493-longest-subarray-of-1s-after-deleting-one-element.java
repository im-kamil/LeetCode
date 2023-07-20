class Solution {
    public int longestSubarray(int[] nums) {
        int zero =0, ans = 0;
        int start=0;
        for(int i=0;i<nums.length; i++){
            zero+=nums[i]==0?1:0;
            while(zero>1){
                zero-=nums[start]==0?1:0;
                start++;
            }
            ans = Math.max(ans,i-start);
        }
        return ans;
    }
}