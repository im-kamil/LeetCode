//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int checkCompressed(String S, String T) {
        // code here
        int s=0, i=0;

        while(i<T.length()){

            if(Character.isAlphabetic(T.charAt(i))){

                if(T.charAt(i) != S.charAt(s)) return 0;

                s++;

                i++;

                continue;

            }

            String num = "";

            while(i<T.length() && Character.isDigit(T.charAt(i))){

                num = num + T.charAt(i++);

            }

            s += Integer.parseInt(num);

            if(i >= T.length()){

                if(s == S.length()) return 1;

                else return 0;

            }

            if(T.charAt(i) != S.charAt(s)) return 0;

        }

        return 1;
    }
}