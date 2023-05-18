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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int n, int m)
    {
        // Code here
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if( !visited[i][j] && matrix[i][j]==1 && DFS(i,j,matrix,visited,n,m) )
                    count++;

        return count;
    }
    boolean DFS(int i,int j,int[][] matrix,boolean[][] visited,int n,int m){
        
        // Base condition 
        if(i>=n-1 || i==0 || j>=m-1 || j==0)
            return false;
        // mark current visited
        visited[i][j] = true;   
        // flag to check if any island goes to boundary or not
        boolean flag = true;
        // Go up
        if(matrix[i-1][j]==1 && !visited[i-1][j])
            flag &= DFS(i-1,j,matrix,visited,n,m);
        // Go down
        if(matrix[i+1][j]==1 && !visited[i+1][j])
            flag &= DFS(i+1,j,matrix,visited,n,m);
        // Go left
        if(matrix[i][j-1]==1 && !visited[i][j-1])
            flag &= DFS(i,j-1,matrix,visited,n,m);
        // Go right
        if(matrix[i][j+1]==1 && !visited[i][j+1])
            flag &= DFS(i,j+1,matrix,visited,n,m);
        
        // it will return true if none of the island through this not reach boundary
        // else false
        return flag;    
    }
}