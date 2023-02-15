//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
      public void dfs(int row,int col,int[][] mat,int[] delrow,int[] delcol,int[][] visited)

    {

        visited[row][col]=1;

        int n=mat.length;

        int m=mat[0].length;

        for(int i=0;i<4;i++)

        {

            int nrow=row+delrow[i];

            int ncol=col+delcol[i];      

            if(nrow>=0 && nrow<n &&ncol>=0 &&ncol<m && mat[nrow][ncol]>=mat[row][col] && visited[nrow][ncol]==0)

            {

                dfs(nrow,ncol,mat,delrow,delcol,visited);

            }

        }

    }
	int water_flow(int [][] mat, int N, int M) {
		//Write your code here
		 int[][] visited1=new int[N][M];

 int[][] visited2=new int[N][M];

     int[] delrow={-1,0,1,0};

     int[] delcol={0,1,0,-1};    

     for(int i=0;i<M;i++)

     {

             dfs(0,i,mat,delrow,delcol,visited1);

             dfs(N-1,i,mat,delrow,delcol,visited2);

     }

     for(int i=0;i<N;i++)

     {

         dfs(i,0,mat,delrow,delcol,visited1);

         dfs(i,M-1,mat,delrow,delcol,visited2);

     }

        int count=0;

     for(int i=0;i<N;i++)

     {

         for(int j=0;j<M;j++)

         {

             if(visited1[i][j]==visited2[i][j] &&visited1[i][j]==1)

             count++;

         }

     }

     return count;
	}
}