class Solution {
    public int subarraySum(int[] nums, int k) {
          //corner case: can nums be null or 0 length? no
        
        //brute force approach
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        
        return result;     // TC = o(n*n)
                           // SC = o(1)
    }
}