//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t > 0){
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A,B));
            t--;
        }
    } 
} 
        


// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
	static int repeatedStringMatch(String A, String B) 
	{ 
        // Your code goes here
        String strA = A;
        int repeat = B.length()/ A.length();
        int count = 1;
        for(int i =0; i<repeat+2; i++){
            if(A.contains(B)) return count++;
            else{
                A+=strA;
                count++;
            }
        }
        return -1;
	} 
} 
