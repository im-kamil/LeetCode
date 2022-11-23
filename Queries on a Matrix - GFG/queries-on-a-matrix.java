//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[][] Queries = new int[q][4];
            for (int i = 0; i < q; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 4; j++)
                    Queries[i][j] = Integer.parseInt(s1[j]);
            }
            Solution obj = new Solution();
            int[][] ans = obj.solveQueries(n, Queries);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    out.print(ans[i][j] + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[][] solveQueries(int n, int[][] Queries) {
        // Code here
        int temp[][] = new int[n][n];
        for(int i=0;i<Queries.length;i++){
            int start_row = Queries[i][0], start_col = Queries[i][1];
            int end_row = Queries[i][2], end_col = Queries[i][3];
            for(int row=start_row;row<=end_row;row++){
                for(int col=start_col;col<=end_col;col++){
                    temp[row][col]++;
                }
            }
        }
    return temp;
    }
}