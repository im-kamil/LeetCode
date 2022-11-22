//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  int min(int i,int s1,int s2, int arr[],int n,int dp[][]){

        

        if(i==n){

            return Math.abs(s1-s2);

        }

        if(dp[i][Math.abs(s1-s2)]!=-1) return dp[i][Math.abs(s1-s2)];

        int a= min(i+1,s1+arr[i],s2,arr,n,dp);

        int b=min(i+1,s1,s2+arr[i],arr,n,dp);

        return dp[i][Math.abs(s1-s2)]=Math.min(a,b);

    }
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;

     for(int i:arr) sum+=i;

     int dp[][]=new int[n+1][sum+1];

     for(int[] a:dp)

     Arrays.fill(a,-1);

     

     return min(0,0,0,arr,n,dp);
	} 
}
