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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int m = G.length;
        int n = G[0].length; //numbers of jobs
        int track[] = new int[n]; // to check jobs are available
        Arrays.fill(track,-1); // filling array with -1
        int result=0;
        for(int i=0;i<m;i++){
          //boolean array reset after every iteration
        boolean visited[] = new boolean[n]; 
            if(matching(i , G , visited , track))result++;
        }
        return result;
    }
    public boolean matching(int curr , int[][] g , boolean[]visited , int[] track){
        for(int i=0;i<g[0].length;i++){
            if(g[curr][i]==1 && !visited[i]){
                visited[i]=true;
                if(track[i]==-1 || matching(track[i] , g , visited ,track)){
                    track[i] = curr; //replacing -1 with curr index
                    return true;
                }
            }
        }
        return false;
    }
}