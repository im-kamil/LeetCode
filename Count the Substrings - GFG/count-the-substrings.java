//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
         int count = 0;
    // Iterate over each character of the string S
    for (int i = 0; i < S.length(); i++) {
        // Initialize variables to keep track of the count of uppercase and lowercase letters
        int upperCount = 0, lowerCount = 0;
        // Iterate over each substring starting from the current index i
        for (int j = i; j < S.length(); j++) {
            // Update the count of uppercase and lowercase letters based on the current character
            if (Character.isUpperCase(S.charAt(j))) {
                upperCount++;
            } else {
                lowerCount++;
            }
            // If the count of uppercase and lowercase letters is equal, then increment the count variable
            if (upperCount == lowerCount) {
                count++;
            }
        }
    }
    // Return the count variable, which represents the total number of substrings that have an equal
    // number of uppercase and lowercase letters
    return count;
    }
} 
