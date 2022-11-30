//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // Your code here
        long[] res = new long[n];
        long[] res2 = new long[n];
        int i;
        long temp=0,temp1=0,temp3=0,temp4=0;
        for(i=0;i<n;i++){
            res[i]=arr[n-i-1];
        }
        for(i=0;i<n;i++){
            res2[i]=arr[i];
        }
        for(i=0;i<n;i++){
            if(i%2==0){
                temp=arr[i];
                arr[i]=res[(int)temp1];
                temp1++;
            }
            if(i%2!=0){
                temp3=arr[i];
                arr[i]=res2[(int)temp4];
                temp4++;
            }
        }
        
    }
    
}


