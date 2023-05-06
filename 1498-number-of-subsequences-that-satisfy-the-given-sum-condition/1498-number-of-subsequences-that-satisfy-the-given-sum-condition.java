class Solution {
    public int numSubseq(int[] nums, int target) {
         Arrays.sort(nums);
        int res=0;
        int toMod=(int)1e9+7;
        //It is impossible to use 2^n in Java when n is very large, but Python can
        //So we need to use DP-method to pre-calculate 2^n % 1e9+7
        int[] powDP = new int[nums.length];
        powDP[0] = 1;
        for(int i=1; i<powDP.length; i++) powDP[i] = (powDP[i-1]*2)%toMod;
        //each time we fix a starting point
        for(int start=0; start<nums.length; start++){
            //like two-sum, we use binary search to find the nums[end] <= target-nums[start]
            //in other word, we use binary search to find the ending point
            int l=start, r=nums.length-1;
            //"end" is to memorize the largest element satisfying our requirement
            //and its initial value -1 is important as well
            int end = -1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(nums[start]+nums[mid]<=target){
                    l=mid+1;
                    end=mid;
                }
                else r=mid-1;
            }
            //so we've got starting and ending points
            
            //we have to consider a situation that we didn't find an element satisfying(nums[end] <= target-nums[start])
            //Then we can stop the iteration and return the result
            if(end==-1) break;
            res = (res + powDP[end-start])%toMod;
        }
        
        return res;
    }
}