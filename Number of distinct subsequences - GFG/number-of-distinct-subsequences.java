//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String S) {
        // code here
          int[] last = new int[26];
        Arrays.fill(last, -1);
        
        int mod = 1000000007;
 
        // Length of input string
        int n = S.length();
 
        // dp[i] is going to store count of distinct
        // subsequences of length i.
        int[] dp = new int[n + 1];
 
        // Empty substring has only one subsequence
        dp[0] = 1;
 
        // Traverse through all lengths from 1 to n.
        for (int i = 1; i <= n; i++) {
            // Number of subsequences with substring
            // S[0..i-1]
            dp[i] = 2 * dp[i - 1];
            dp[i] %= mod;
 
            // If current character has appeared
            // before, then remove all subsequences
            // ending with previous occurrence.
            if (last[S.charAt(i - 1)-'a'] != -1)
                dp[i] = (dp[i] - dp[last[S.charAt(i - 1)-'a']] + mod) % mod;
 
            // Mark occurrence of current character
            last[S.charAt(i - 1)-'a'] = (i - 1);
        }
 
        return dp[n];
    }
}