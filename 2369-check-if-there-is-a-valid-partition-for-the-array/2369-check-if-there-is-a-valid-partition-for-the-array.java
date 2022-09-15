class Solution {
    public boolean validPartition(int[] nums) {
         int n = nums.length;
        boolean valid[] = new boolean[n];
        
        if(nums[1]==nums[0]) valid[1] = true;
        if(n==2) return valid[1];
        
        if(nums[2]==nums[1] && nums[1]==nums[0]) valid[2] = true;
        if(nums[2]==nums[1]+1 && nums[1]==nums[0]+1) valid[2] = true;
        if(n==3) return valid[2];
        
        for(int i=3; i<n; i++){
            if(nums[i]==nums[i-1] && valid[i-2]) valid[i] = true;
            if(nums[i]==nums[i-1] && nums[i-1]==nums[i-2] && valid[i-3]) valid[i] = true;
            if(nums[i]==nums[i-1]+1 && nums[i-1]==nums[i-2]+1 && valid[i-3]) valid[i] = true;
        }
        return valid[n-1];
    }
}