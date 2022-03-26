class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        for(int i = 0; i<nums.length-1; i++){
            int left = i+1;
            int right = nums.length-1;
            int target = 0 - nums[i];
            while(left<right){
                if(nums[left] + nums[right] == target){
                    List<Integer> internal = new ArrayList<>();
                    internal.add(nums[i]);
                    internal.add(nums[left]);
                    internal.add(nums[right]);
                    res.add(internal);
                    while(left<right && nums[left] == internal.get(1)) left++;
                    while(left<right && nums[right] == internal.get(2)) --right;
                }else if(nums[left] + nums[right] > target){
                    right--;
                }else{
                    left++;
                }
                
            }
            while(i+1<nums.length-1 && nums[i+1] == nums[i]) ++i;
        }
        return res;
    }
}