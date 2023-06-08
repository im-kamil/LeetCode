class Solution {
    public void moveZeroes(int[] nums) {
//         if (nums == null || nums.length == 0) return;        

//     int insertPos = 0;
//     for (int num: nums) {
//         if (num != 0) nums[insertPos++] = num;
//     }        

//     while (insertPos < nums.length) {
//         nums[insertPos++] = 0;
//     }
        int  count =0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]!=0){
                nums[count++] = nums[i];
            }
        }
        while(count<nums.length){
            nums[count++]=0;
        }
    }
}