class Solution {
    public boolean increasingTriplet(int[] nums) {
        //  int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        // for (int n : nums) {
        //     if (n <= small) { small = n; } // update small if n is smaller than both
        //     else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
        //     else return true; // return if you find a number bigger than both
        // }
        // return false;
        if(nums.length<3) return false;
        int i=Integer.MAX_VALUE, j=Integer.MAX_VALUE;
        for(int in=0;in<nums.length;in++){
            if(nums[in]<=i){
                i = nums[in];
            }else if(nums[in]<=j){
                j = nums[in];
            }else {
                return true;
            }
        }
        return false;
    }
}