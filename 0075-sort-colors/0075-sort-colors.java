class Solution {
    public void sortColors(int[] nums) {
//         var low =0;
//         var mid =0;
//         var high = nums.length-1;
        
//         while(mid<=high){
//             switch(nums[mid]){
//                case :0 {
//                     swap(nums, low, mid);
//                     low++;
//                     mid++;
//                     break;
//             }
//                 case : 1{
//                     mid++;
//                     break;
//         }
//                 case : 2{
//                     swap(nums, mid, high);
//                     high--;
//                     break;
   int low=0,mid=0,high=nums.length-1, temp;
        while(mid<=high){
            switch(nums[mid]){
                case 0:{
                     temp=nums[low];
                    nums[low]=nums[mid];
                    nums[mid]=temp;
                   
                    low++;
                    mid++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp=nums[high];
                    nums[high]=nums[mid];
                    nums[mid]=temp;
                    high--;
                    break;
                }
            }
        }
    }
}