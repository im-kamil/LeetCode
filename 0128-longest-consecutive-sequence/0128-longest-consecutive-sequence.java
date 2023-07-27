class Solution {
    public  int longestConsecutive(int[] nums) {
//         Set<Integer> result = new HashSet<>();
//         int n = nums.length;
//         for(int a: nums){
//             result.add(a);
//         }
        
//         int maxcount = 0;
//         for(int i=0;i<n;i++){
//             int curcount = 0;
//             int check = nums[i];
//             if(!result.contains(check-1)){
//                 while(result.contains(check++)){
//                     curcount++;
//                 }
//                 if(curcount > maxcount){
//                     maxcount = curcount;
//                 }
                
//             }
            
//         }
        
//         return maxcount;
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int num:nums){
            hashSet.add(num);
        }
        int LongestStreak = 0;
        for(int num : nums){
            if(!hashSet.contains(num-1)){
                int currNum = num;
                int currStreak = 1;
                while(hashSet.contains(currNum+1)){
                    currNum+=1;
                    currStreak+=1;
                }
                LongestStreak = Math.max(LongestStreak, currStreak);
            }
        }
        return LongestStreak;
    }
}