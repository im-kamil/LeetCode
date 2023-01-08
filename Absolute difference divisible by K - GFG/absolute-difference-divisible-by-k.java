//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());
			String S[] = read.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(S[i]);
			int k = Integer.parseInt(read.readLine());

			Solution ob = new Solution();
			System.out.println(ob.countPairs(n, arr, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	static long countPairs(int n, int[] arr, int k) {
		// code here
		int ans[] = new int[k]; // To store the same remender frequency we need k size array.

 for(int i = 0; i < n; i++){

     int rem = arr[i] % k;

     ans[rem]++; // stor the freqency

 }

 int count = 0;

 for(int i = 0; i < ans.length; i++){

     //Intutation Behind this is for Example your hava 2 number how many freqency you maken*(n - 1) / 2. That's the logic which i used here.

     count += (ans[i] * (ans[i] - 1)) / 2;

 }

 return (long)count;


	}
}