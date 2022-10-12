class Solution {
    public int largestPerimeter(int[] nums) {
        // int a =2, b=1, c =2;
        // int sum = 5;
        // for(int i =0; i<4; i++){
        //     if(a+b+c==sum) {
        //         sum= a+b+c;
        //     }else {
        //         return 0;
        //     }
        // }
        //     return sum;
         Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; --i)
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        return 0;
    }
}