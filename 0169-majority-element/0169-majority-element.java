class Solution {
    public int majorityElement(int[] nums) {
    //      int c=0,ele=0;
    //     for(int n:nums){
    //         if(c==0) ele=n;
    //         if(n==ele) c++;
    //         else c--;
    //     }
    //     return ele;
    //
    int count = 0;
        int element = 0;
        for(int n:nums){
            if(count==0) element=n;
            if(n==element) count++;
            else count--;
        }
        return element;
    }
}