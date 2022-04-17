class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3) return nums.length;
        int in=2;
        
        for(int i=2; i<nums.length; i++){
            if(nums[i]!=nums[in-2]){
                nums[in++]=nums[i];
            }
        }
        return in;
    }
}