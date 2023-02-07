//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
          int i=0;

        int max = 0;

        while(i<n){

            int start = i, end = i, firNeg=-1, lastNeg = -1, count =0;

            while(start < n && arr[start] == 0) start++;

            end = start;

            while(end < n && arr[end] != 0){

                if(arr[end] < 0){

                    count++;

                    if(firNeg==-1) firNeg = end;

                    lastNeg = end;

                }

                end++;

            } 

            if(count %2 == 0) max = Math.max(end-start, max);

            else{

                // System.out.println(firNeg + " "+ lastNeg);

                if(firNeg != -1) max = Math.max(end-firNeg-1, max);

                if(lastNeg != -1) max = Math.max(lastNeg-start, max);

            }

            i = end+1;   

        }

        return max;
    }
   
}