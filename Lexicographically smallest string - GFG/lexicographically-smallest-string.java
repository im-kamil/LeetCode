//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
// Position this line where user code will be pasted.
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            String S = input[0];
            int k =  Integer.parseInt(input[1]);
            Solution ob = new Solution();

            System.out.println(ob.lexicographicallySmallest(S, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String lexicographicallySmallest(String S, int k) {
        // code here
        Stack<Character> st = new Stack<Character>();

        

        StringBuilder ans = new StringBuilder();

        

        int n = S.length();

           

         k = n!= 0 && (n&(n-1)) == 0 ? k/2 : k*2;

         

     

        if(k>=n)

            return "-1";

        

        for(int i=0; i<n; i++){

            while(k>0 && !st.isEmpty() && st.peek()>S.charAt(i)){

                st.pop();

                k--;

            }

            st.push(S.charAt(i));

        }

 

        while(k>0 && !st.isEmpty()){

            st.pop();

            k--;

        }

 

        while(!st.isEmpty()){

            ans.append(st.pop());

        }

        

        return ans.reverse().toString();
    }
}