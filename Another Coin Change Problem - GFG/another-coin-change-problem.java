//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        int dp[][]=new int[K+1][target+1];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return solvetab(N,K,target,coins,dp);
    }
    
    static boolean solve(int n,int k,int target,int []coins,int dp[][])
    {
        if(k==0 && target==0)
        {
            dp[k][target]=1;
            return true;
        }
        if(dp[k][target]!=-1)
        {
            if(dp[k][target]==0)
            return false;
            else
            return true;
        }
        boolean ans=false;
        for(int i:coins)
        {
            if(i<=target && k>0)
            ans=solve(n,k-1,target-i,coins,dp);
            if(ans==true)
            break;
        }
        if(ans==true)
        {
            dp[k][target]=1;
        }
        else
        {
            dp[k][target]=0;
        }
        return ans;
    }
    
    static boolean solvetab(int n,int k,int target,int []coins,int dp[][])
    {
        for(int i=0;i<=k;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                }
                else
                {   boolean ans=false;
                    for(int c:coins)
                    {
                        if(c<=j && i>0)
                        ans=dp[i-1][j-c]==1?true:false;
                        if(ans==true)
                        break;
                    }
                    if(ans==true)
                    {
                        dp[i][j]=1;
                    }
                    else
                    {
                        dp[i][j]=0;
                    }
                }
            }
            
        }
        
        if(dp[k][target]==1)
        return true;
        else
        return false;
        
    }
}
