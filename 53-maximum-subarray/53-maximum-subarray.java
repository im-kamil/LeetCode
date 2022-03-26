class Solution {
    public int maxSubArray(int[] nums) {
//         int max = Integer.MIN_VALUE;
        
//         for(int i=0; i<nums.length; i++){ // range 1,2,3,4
//             int sum = 0;
//             for(int j=i; j<nums.length; j++){
//                 // for(int k=i; k<=j; k++){
//                 //     sum = sum+nums[k];
//                 // }
//                 sum = sum+nums[j];
//                 max = Math.max(sum,max);
//             }
//         }
//         return max;
        int bestsum = Integer.MIN_VALUE;
        int currentsum = 0;
         for(int i=0; i<nums.length; i++){
             currentsum = Math.max(nums[i] , currentsum+nums[i]);
             bestsum = Math.max(bestsum, currentsum);
         }
        return bestsum;
    }
}