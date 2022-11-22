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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void solve(int n,int m,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> tmp){
        if(n==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int k = m;k>=1;k--){
            if(n-k>=0){
                tmp.add(k);
                solve(n-k,k,ans,tmp);
                tmp.remove((Integer)k);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        solve(n,n,ans,tmp);
        return ans;
    }
}