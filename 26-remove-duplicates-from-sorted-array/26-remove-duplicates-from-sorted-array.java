class Solution {
    public int removeDuplicates(int[] nums) {
         int pointer1 = 0;
        for(int pointer2 = 1; pointer2 < nums.length; pointer2++) {
            if(nums[pointer2] != nums[pointer1]) {
                pointer1++;
                nums[pointer1] = nums[pointer2];
            }
        }
        return pointer1 + 1;
    }
}