class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> mp=new HashMap<>();
        
        int i,n=nums.length,a=-1,b=-1;
        for(i=0;i<n;i++){
            
            if(mp.containsKey(target-nums[i])){
                a=mp.get(target-nums[i]);
                b=i;
                break;
            }
            mp.put(nums[i],i); 
        }
        
        return new int[]{a,b};
        
    }
}