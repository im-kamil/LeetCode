class Solution {
    public int commonFactors(int a, int b) {
        int n = gcd(a, b);
 
        // Count divisors of n.
        int result = 0;
        for (int i = 1; i <= n; i++) {
            // if 'i' is factor of n
            if (n % i == 0) {
                result++;
            }
        }
        return result;
    }
    static int gcd(int a, int b){
        if (a == 0)
            return b;
 
        return gcd(b % a, a);
    
    }
}