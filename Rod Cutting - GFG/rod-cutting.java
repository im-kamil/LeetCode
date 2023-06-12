//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int res[] = new int[n+1];
        Arrays.fill(res, Integer.MIN_VALUE);
        res[0]=0;
        for(int i=1;i<=n;i++){
            res[i]=price[i-1];
            for(int j=0;j<i;j++){
                res[i]=Math.max(res[i],res[j]+res[i-j]);
            }
        }
        return res[n];
    }
}