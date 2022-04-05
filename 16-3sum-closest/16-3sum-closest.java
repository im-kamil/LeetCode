class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int closest = 0;
        int diff = Integer.MAX_VALUE;
        
        for(int i=0;  i<nums.length-2 ;i++){
            int l = i+1;
            int r = nums.length-1;
            
            while(l<r){
                while(l<r){
                     int sum = nums[i]+nums[l]+nums[r];
                    
                    if(Math.abs(target-sum )<= diff ){
                        diff= Math.abs(target-sum );
                        closest = sum;
                    }
                    r--;
                }
                l++;
                r=nums.length-1;
               
                
              
            }
        }
        return closest;
        
    }
}