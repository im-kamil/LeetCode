//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		//Write your code here
		int prev = arr[0];
        int l = 0,r = -1;
        int i =0;
        for(i=1;i<n;i++) {
            if(prev%2==arr[i]%2) {
                
            }
            else {
                
                Arrays.sort(arr,l,i);
                
                
                int a= l;
                int b = i-1;
                while(a<b) {
                    int temp= arr[a];
                    arr[a]  = arr[b];
                    arr[b]=temp;
                    a++;
                    b--;
                }
                //System.out.println(l+" "+i);
                l = i;
                prev = arr[i];
                
            }
        }
        Arrays.sort(arr,l,i);
        int a= l;
        int b = i-1;
        while(a<b) {
            int temp= arr[a];
            arr[a]  = arr[b];
            arr[b]=temp;
            a++;
            b--;
        }
    //    System.out.println(l+" "+i);
        
    //    System.out.println(Arrays.toString(arr));
    return arr;
	}
}