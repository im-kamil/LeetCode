//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static class Fours{
        int i,j;
        int dist; int obs;
        Fours(int i,int j,int dist,int obs){
            this.i=i; this.j=j; this.dist=dist; this.obs=obs;
        }
    }
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        ArrayDeque<Fours> q = new ArrayDeque<>();
        q.add(new Fours(0,0,0,k));
        boolean visited[][][] = new boolean[n][m][k+1];
        visited[0][0][k]=true;
        int dx[] = {1,0,0,-1};
        int dy[] = {0,1,-1,0};
        while(!q.isEmpty()){
            Fours curr = q.poll();
            int i=curr.i, j=curr.j, dist=curr.dist, obs=curr.obs;
            if(i==n-1 && j==m-1) return dist;
            for(int dir=0; dir<4; dir++){
                int ni=i+dx[dir], nj=j+dy[dir];
                if(ni>=0 && nj>=0 && ni<n && nj<m && !visited[ni][nj][obs]){
                    if(mat[ni][nj]==0){
                        visited[ni][nj][obs]=true;
                        q.add(new Fours(ni,nj,dist+1,obs));
                    }else if(mat[ni][nj]==1 && obs>0){
                        visited[ni][nj][obs]=true;
                        q.add(new Fours(ni,nj,dist+1,obs-1));
                    }
                }
            }
        }
        return -1;
    }
};