public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int count =0, mask = 1;
        // for(int i =0; i<32; i++){
        //     if((n&mask)!=0) count++;
        //     mask = mask<<1;
        // }
        // return count;
         if(n==0) return 0;
         if(n==1) return 1;    
        return hammingWeight(n & (n-1))+1;
    }
}