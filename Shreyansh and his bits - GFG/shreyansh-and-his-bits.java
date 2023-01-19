//{ Driver Code Starts
//Initial Template for Java

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
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{

    

    long count(long n)

    {

        long temp=n;

        int cnt=0;

        int len=0;

        

        long dp[][]=new long[67][67];

        

        long res=0l;

        

        while(temp>=1)

        {

            if((temp&1)==1)

            {

                cnt++;

                res+=find(len,cnt,dp);

            }

            len++;

            temp=temp>>1;

        }

        

        return res;

        

    }

    public static long find(int n,int c,long dp[][])

    {

        if(n<0||c<0)

        return 0;

        

        if(c>n)

        return 0l;

        

        if(n==c)

        return 1l;

        

        if(dp[n][c]>0)

        return dp[n][c];

        

        dp[n][c]=find(n-1,c,dp)+find(n-1,c-1,dp);

        return dp[n][c];

    }

    

}
 