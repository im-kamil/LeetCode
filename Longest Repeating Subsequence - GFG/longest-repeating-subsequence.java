//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int n = str.length();

        int dp[][] = new int[n+1][n+1];

        

        for(int i=n-1;i>=0;i--) {

            for(int j=n-1;j>=0;j--) {

                if(str.charAt(i)==str.charAt(j) && i!=j) {

                    dp[i][j] =  1+dp[i+1][j+1];

                }

                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);

            }

        }

        return dp[0][0];
    }
}