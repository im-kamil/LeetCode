class Solution {
    public int majorityElement(int[] nums) {
         int c=0,ele=0;
        for(int n:nums){
            if(c==0) ele=n;
            if(n==ele) c++;
            else c--;
        }
        return ele;
    }
}