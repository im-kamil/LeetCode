//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minOperation(String s) {
        // code here
          int i,j,n=s.length();

        int count=0;

        String temp="";

        int val=0;

        boolean flag=false;

        if(s.length()==1)

        return 1;

        for(i=0;i<n;i++)

        {

            temp+=s.charAt(i);

            count++;

           // System.out.println(temp+" "+count);

            boolean found=false;

            String k=s.substring(i+1,Math.min(i+1+temp.length(),n));

            if(k.equals(temp))

            {

                val=Math.max(val,k.length());

            }

        }

       // System.out.println(val);

        return count-val+1;
    }
}