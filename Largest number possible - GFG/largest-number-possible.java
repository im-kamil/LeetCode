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
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
         if(N==1 && S>9 || N>1 && S==0){
            return "-1";
        } 
        if((9*N)<S){
            return "-1";
        }
        String s="";
        while(N>0){
            if(S>9){
                 s=s+"9"; 
                 S-=9;
            }
            else{ 
                s=s + Integer.toString(S);
                S=0;
            }
            N--;
        }
       
        return s;
    }
}