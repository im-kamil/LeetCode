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
   int[][] dp;
     String longestPalin(String s){
        // code here
        int n=s.length();
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int temp=function(s,0,s.length()-1);
        // System.out.println(temp);
        if(temp==1) return ""+s.charAt(0);
        
        String t=ans;
        ans="";
        return t;
    }
     boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
     String ans="";
     
     int function(String s,int i,int j){
        if(i>j) return 0;
        if(i==j) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(isPalindrome(s,i,j)){
            if(ans.length()<j-i+1){
                ans=s.substring(i,j+1);
            }
            return dp[i][j]=j-i+1;
        }
        
        return dp[i][j]=Math.max(function(s,i,j-1),function(s,i+1,j));
    }
}