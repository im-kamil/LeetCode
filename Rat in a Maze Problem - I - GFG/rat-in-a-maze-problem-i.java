//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
     static void solve(int row,int col,int n,int m[][],ArrayList<String>ans,String s,int vis[][]){

        if(row==n-1 && col==n-1){

            ans.add(new String(s));

            return;

        }

        if(row<0 || col<0 || row>=n || col>=n || m[row][col]==0 || vis[row][col]==1)

        return;

        

        vis[row][col]=1;

        solve(row+1,col,n,m,ans,s+'D',vis);

        solve(row,col+1,n,m,ans,s+'R',vis);

        solve(row-1,col,n,m,ans,s+'U',vis);

        solve(row,col-1,n,m,ans,s+'L',vis);

        vis[row][col]=0;

          

    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String>ans=new ArrayList<>();

        if(m[0][0]==0 || m[n-1][n-1]==0){

            ArrayList<String>list=new ArrayList<>();

            list.add("-1");

            return list;

        }

        int vis[][]=new int[n][n];

        solve(0,0,n,m,ans,"",vis);

        return ans;
    }
}