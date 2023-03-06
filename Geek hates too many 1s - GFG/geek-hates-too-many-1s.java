//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int num) {
        // code here
          String str = Integer.toBinaryString(num);

        int n = str.length();

        for ( int i=2; i<n; i++){

            if(str.charAt(i)=='1' && str.charAt(i-1)=='1' && str.charAt(i-2)=='1'){

                num-=Math.pow(2,n-i-1);

                i+=2;

            }

        }

        return num;
    }
}
        
