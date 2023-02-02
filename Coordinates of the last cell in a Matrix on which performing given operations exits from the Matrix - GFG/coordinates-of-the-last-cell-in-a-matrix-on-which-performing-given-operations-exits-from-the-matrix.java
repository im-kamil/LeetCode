//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
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
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    private static int movex(int move, int x)
    {
        if(move==0) return x-1;
        if(move==2) return x+1;
        return x;
    }
    
    
    private static int movey(int move, int y)
    {
        if(move==1) return y+1;
        if(move==3) return y-1;
        return y;
    }
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int x = 0, y = 0, move = 1;
        
        while(x<m && y<n && x>=0 && y>=0)
        {
            if(arr[x][y]==1)
            {
                arr[x][y] = 0;
                move = (move+1)%4;
            }
            
            x = movex(move, x);
            y = movey(move, y);
            
        }
        
        if(x>=m) x--;
        if(x<0) x++;
        if(y>=n) y--;
        if(y<0) y++;
        
        
        return new int[]{x, y};
        
    }
}