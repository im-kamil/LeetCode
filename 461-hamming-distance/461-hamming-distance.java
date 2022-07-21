class Solution {
    public int hammingDistance(int x, int y) {
//         int ans =0;
//         for(int i =0; i<N; i++){
//             int c =0;
//             for(int i=0; i<N; i++){
//                 if(arr[j] & arr[i]>0)
//                     count++;
                
//             }
//             ans = ans*(N-1)*2;
//         }
//         return ans ;
        return Integer.bitCount(x^y);
    }
}