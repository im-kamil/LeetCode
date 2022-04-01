class Solution {
    public boolean containsDuplicate(int[] nums) {
          HashSet<Integer> numsInArray = new HashSet<Integer>(nums.length); 
        for (int i = 0; i < nums.length; i++) {              
            if(numsInArray.contains(nums[i]))                 

                return true;                                  
            else
                numsInArray.add(nums[i]);                    
        }
        return false;  
    }
}