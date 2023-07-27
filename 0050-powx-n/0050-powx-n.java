class Solution {
    public double myPow(double x, int n) {
         if(n == 0)
            return 1;
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
        // double ans = 0;
        // long nn = n;
        // if(nn<0) nn = -1*nn;
        // while(nn>0){
        //     if(nn%2==1){
        //         ans = ans*x;
        //         nn = nn-1;
        //     }else{
        //         x = x*n;
        //         nn = nn/2;
        //     }
        // }
        // if(n<0) ans = (double)(1.0)/(double)(ans);
        // return ans ;
    }
}