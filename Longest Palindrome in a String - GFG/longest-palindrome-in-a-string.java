//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{ 
    public static void fun(String S, int [][] dp){
        int n = S.length();
        int gap=0;
        while(gap < n){
            int i=0, j= gap;
            while(i<n && j<n){
                if(gap == 0) dp[i][j] = 1;
                else if(gap == 1){
                    if(S.charAt(i) == S.charAt(j)) dp[i][j] = 1;
                    else dp[i][j] = 0;
                }else{
                    if(S.charAt(i) == S.charAt(j) && dp[i+1][j-1] == 1) dp[i][j] = 1;
                    else dp[i][j] = 0;
                }
                i++;
                j++;
            }
            gap++;
        }
    }
    static String longestPalin(String S){
        int n = S.length();
        int dp[][] = new int[n][n];
        String st="";
        int max=0;
        fun(S,dp);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] == 1) {
                    if(j-i+1 > max) {
                        max = j-i+1;
                        st= S.substring(i,j+1);
                    }
                    
                }
            }   
        }
        return st;
        
    }
}