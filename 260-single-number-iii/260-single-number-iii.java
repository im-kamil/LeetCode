class Solution {
    public int[] singleNumber(int[] nums) {
       int xor=0; // this will provide us the xor of the two distict numbers.
           for(int n:nums){
            xor=xor^n;
               }

        int set_bit=0; // this finds the last set bit of xor.
        
        for(int i=0;i<32;i++){
            if((xor&(1<<i))!=0){
                set_bit=1<<i;
            }
        }
        
        int[] ans=new int[2];// to divide nums into two groups which will eventually contain the required         distinct numbers.
        
        for(int n:nums){
            if((n&set_bit)==0){
                ans[0]^=n;
            }else{
                ans[1]^=n;
            }
        }
        
        return ans;
    }
}