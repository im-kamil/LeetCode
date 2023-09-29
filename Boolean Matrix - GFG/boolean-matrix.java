//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Templat1e for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // code here 
        int R = matrix.length;
        int C = matrix[0].length;
        // int row[] = new int[R];
        // int col[] = new int[C];
        
        // for(int i=0; i<R; i++){
        // row[i] = 0;
        
        // }
        // for(int j=0; j<C; j++){
        //     row[j] = 0;
        // }
        // for(int i=0; i<R; i++){
        //     for(int j=0; j<C; j++){
        //         if(matrix[i][j]==1){
        //             row[i]=1;
        //             col[j]=1;
        //         }
        //     }
        // }
        // for(int i=0; i<R; i++){
        //     for(int j=0; j<C; j++){
        //         if(row[i]==1 || col[j]==1){
        //             matrix[i][j]=1;
        //         }
        //     }
        // }
        boolean []indexValue = new boolean[R+C];
        for(int i=0; i<R; i++){
            for(int j=0;  j<C; j++){
                if(matrix[i][j]==1){
                    indexValue[i]=true;
                    indexValue[R+j]= true;
                }
            }
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(indexValue[i]||indexValue[R+j]){
                    matrix[i][j]=1;
                }
            }
        }
    }
}