class Solution {
    public int[] searchRange(int[] nums, int target) {
//         // define array for sortinng output
//         int arr[] = new int[2];
//         // intialize with -1
//         Arrays.fill(arr, -1);
//         // border case
//         if(nums==null || nums.length==0) return arr;
//         // utility variabl3s for binary search
//         int low=0; mid=0; hi = nums.length-1;
        
//         while(low<=hi){
//             mid = low+(hi-low)/2;
// //             if you see a number greater than or equal to a target then move towards left
//             if(nums[mid]==target){
//                 arr[0] = mid;
//                 hi=mid-1;
//             }else if(nums[mid>target]) hi = mid-1;
//             else low = mid+1;
//         }
//         low = 0;
//         hi = nums.length-1;
        
         
//         while(low<=hi){
//             mid = low+(hi-low)/2;
// //             if you see a number less than or equal to a target then move towards right
//             if(nums[mid]==target){
//                 arr[1] = mid;
//                 hi=mid+1;
//             }else if(nums[mid>target]) hi = mid-1;
//             else low = mid+1;
//         }
//         return arr;
//     }
//     }
           int[] result = new int[2];
    result[0] = findFirst(nums, target);
    result[1] = findLast(nums, target);
    return result;
}

private int findFirst(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] >= target){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}

private int findLast(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] <= target){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}
}