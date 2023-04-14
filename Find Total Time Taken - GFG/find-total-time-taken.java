//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            int n=Integer.parseInt(in.readLine().trim());
            int a[]=new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            s=in.readLine().trim().split(" ");
            int time[]=new int[n];
            for(int i=0;i<n;i++){
                time[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans=ob.totalTime(n,a,time);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long totalTime(int n,int arr[],int time[])
    {
        Map<Integer, Long> s = new HashMap<>();
        s.put(arr[0], 0l);
        long ans = 0l;
        for(int i=1 ; i<n ; i++){
            ans++;
            if(!s.containsKey(arr[i])){
                s.put(arr[i], ans);
                // ans++;
            }
            else{
                ans += (ans - s.get(arr[i])) >= time[arr[i]-1] ? 0 : time[arr[i]-1] - (ans - s.get(arr[i]));
                // s.remove(arr[i]);
                s.put(arr[i], ans);
            }
        }
        return ans;
    }
}