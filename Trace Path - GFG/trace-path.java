//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
        // code here
          int hc=0,vc=0,minr=0,maxr=0,minc=0,maxc=0;
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='L'){
                hc++;
            }
            else if(s.charAt(i)=='R'){
                hc--;
            }
            else if(s.charAt(i)=='U'){
                vc++;
            }
            else{
                vc--;
            }
            minr=Math.min(minr,vc);
            maxr=Math.max(maxr,vc);
            minc=Math.min(minc,hc);
            maxc=Math.max(maxc,hc);
            
        }
        if(maxr-minr < n && maxc-minc < m)
        return 1;
        return 0;
    }
}