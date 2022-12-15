//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            String a1[] = in.readLine().trim().split("\\s+");
            int ty = Integer.parseInt(a1[0]);
            int i = Integer.parseInt(a1[1]);
            int j = Integer.parseInt(a1[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.hopscotch(n, m, mat, ty, i, j));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) 
    {
        // code here
        int sum=0;
        if(ty==0)
        {
            if(i-1>=0)
                sum+=mat[i-1][j];
            if(i+1<n)
                sum+=mat[i+1][j];
            if(j-1>=0)
                sum+=mat[i][j-1];
            if(j+1<m)
                sum+=mat[i][j+1];
            if(j%2 == 1)
            {
                if(i+1<n)
                {
                    if(j-1>=0)
                        sum+=mat[i+1][j-1];
                    if(j+1<m)
                        sum+=mat[i+1][j+1];
                }
            }
            else
            {
                if(i-1>=0)
                {
                    if(j-1>=0)
                        sum+=mat[i-1][j-1];
                    if(j+1<m)
                        sum+=mat[i-1][j+1];
                }
            }
            return sum;
        }
        else
        {
            if(i-2>=0)
                sum+=mat[i-2][j];
            if(i+2<n)
                sum+=mat[i+2][j];
            if(j-2>=0)
                sum+=mat[i][j-2];
            if(j+2<m)
                sum+=mat[i][j+2];
            if(i-1>=0)
            {
                if(j-2>=0)
                    sum+=mat[i-1][j-2];
                if(j+2<m)
                    sum+=mat[i-1][j+2];
            }
            if(i+1<n)
            {
                if(j-2>=0)
                    sum+=mat[i+1][j-2];
                if(j+2<m)
                    sum+=mat[i+1][j+2];
            }
            if(j%2 == 1)
            {
                if(i-1>=0)
                {
                    if(j-1>=0)
                        sum+=mat[i-1][j-1];
                    if(j+1<m)
                        sum+=mat[i-1][j+1];
                }
                if(i+2<n)
                {
                    if(j-1>=0)
                        sum+=mat[i+2][j-1];
                    if(j+1<m)
                        sum+=mat[i+2][j+1];
                }
            }
            else
            {
                if(i+1<n)
                {
                    if(j-1>=0)
                        sum+=mat[i+1][j-1];
                    if(j+1<m)
                        sum+=mat[i+1][j+1];
                }
                if(i-2>=0)
                {
                    if(j-1>=0)
                        sum+=mat[i-2][j-1];
                    if(j+1<m)
                        sum+=mat[i-2][j+1];
                }
            }
            return sum;
        }
    }
}