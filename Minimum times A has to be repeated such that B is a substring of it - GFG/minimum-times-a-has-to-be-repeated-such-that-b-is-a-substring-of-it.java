//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        String temp = A;
        int cnt = 1;
        while(temp.length() < B.length()){
            temp += A;
            cnt++;
        }
        if(temp.contains(B) == false){
            temp += A;
            if(temp.contains(B) == true)return cnt+1;
            return -1;
        }
        else return cnt;
    }
};