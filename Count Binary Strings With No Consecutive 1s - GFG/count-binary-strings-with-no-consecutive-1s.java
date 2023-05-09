//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            long N = Long.parseLong(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.countStrings(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int mod = 1000000007;
    public int countStrings(long N) {
        // Code here
         return fib(N+2);
    }
    static int fib(long n) {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (n == 0) return 0;
        power(F, n-1);
        return (int)F[0][0];
    }
    static void power(long F[][], long n) {
        if( n == 0 || n == 1) return;
        long M[][] = new long[][]{{1,1},{1,0}};
        power(F, n/2);
        multiply(F, F);
        if (n%2 != 0) multiply(F, M);
    }
    static void multiply(long F[][], long M[][]) {
        long x =  ((F[0][0]*M[0][0])%mod + (F[0][1]*M[1][0])%mod)%mod;
        long y =  ((F[0][0]*M[0][1])%mod + (F[0][1]*M[1][1])%mod)%mod;
        long z =  ((F[1][0]*M[0][0])%mod + (F[1][1]*M[1][0])%mod)%mod;
        long w =  ((F[1][0]*M[0][1])%mod + (F[1][1]*M[1][1])%mod)%mod;
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}