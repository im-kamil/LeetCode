//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Solution ob = new Solution();
            System.out.println(
                ob.isItPossible(S[0], S[1], S[0].length(), S[1].length()));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isItPossible(String S, String T, int M, int N) {
        // code here
        S = S.replace("#", "");

T = T.replace("#", "");

return S.equals(T) ? 1 : 0;
    }
};