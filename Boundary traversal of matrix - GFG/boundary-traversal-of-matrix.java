//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        if(m==1){
            for(int i=0; i<n; i++){
                ans.add(matrix[i][0]);
            }
            return ans;
        }
        if(n==1){
            for(int i=0; i<m; i++){
                ans.add(matrix[0][i]);
            }
            return ans;
        }
        for(int j=0;j<m; j++){
            ans.add(matrix[0][j]);
        }
        for(int j=1; j<n; j++){
            ans.add(matrix[j][m-1]);
        }
        for(int j=m-2;j>=0; j--){
            ans.add(matrix[n-1][j]);
        }
        for(int j=n-2;j>=1; j--){
            ans.add(matrix[j][0]);
        }
        return ans;
    }
}
