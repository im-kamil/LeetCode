//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
       long p1[]=new long[n];
        if(n==1){
            long p[]={1};
            return p ;
        }
        else if(n==2){
            long p[]={1,1};
           return p;
        }
        else{
            long a=1;
            long b=1;
           
           p1[0]=1;
           p1[1]=1;
            for(int i=2;i<n;i++){
                 a=p1[i-1];
                  b=p1[i-2];
                long c=a+b;
                p1[i]=c;
                 
            }
        }
        return p1;
        
    }
}