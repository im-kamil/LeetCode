//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{ 
    public int solve(int nums[],int k,int i,int n,int dp[][])

    {

        if(i==nums.length)

        return 0;

        if(dp[i][n]!=-1)

        return dp[i][n];

        int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;

        if(n+nums[i]<k)

        {

        if(n==0)    

        x=solve(nums,k,i+1,n+nums[i],dp);

        if(n!=0)

        x=solve(nums,k,i+1,n+nums[i]+1,dp);

        }

        if(n!=0)

        y=solve(nums,k,i,0,dp)+(int)Math.pow((k-n),2);

        return dp[i][n]=Math.min(x,y);

    }

    public int solveWordWrap (int[] nums, int k)

    {

        int dp[][]=new int[nums.length][k+1];

        for(int i=0;i<nums.length;i++)

        Arrays.fill(dp[i],-1);

        return solve(nums,k,0,0,dp);

        // Code here 

    }

}