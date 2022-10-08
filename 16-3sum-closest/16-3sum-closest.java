class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum  = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                
                if (sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return (target-diff);
    }
}