class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double ans =0;
        double window =0;
        for(int i=0;i<k;i++){
            window += nums[i];
        }
        ans = window/k;
        for(int right=k;right<nums.length;right++){
            window+= nums[right]-nums[right-k];
            ans = Math.max(ans, window/k);
        }
        return ans;
    }
}