//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int recurse(int arr[],int n,int i,int []dp)
    {
        // Base Case, if i reaches end of the array
        
        if(i>=n)
            return 0;
            
        // Checking if we already calculated sum for index i in previous recursive calls
        // And returning that if we did
        
        if(dp[i]!=-1)
            return dp[i];
            
        // Otherwise we make recursive calls
        
        int a=recurse(arr,n,i+1,dp);  // If we do not consider current element arr[i]
        int b=arr[i]+recurse(arr,n,i+2,dp);  // If we do consider current element arr[i] 
        
        int max=Math.max(a,b);
        dp[i]=max; // Storing maximum between both options in array for later recursive calls 
        
        return max; // returning maximum between both the values
    }
    int findMaxSum(int arr[], int n) {
        // code here
        int dp[]=new int[n+1]; // Array used for memoization
        Arrays.fill(dp,-1); // Setting default value as -1
        return recurse(arr,n,0,dp);
    }
}