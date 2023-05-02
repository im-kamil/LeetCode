//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxSweetness(int [] sweetness, int N, int K) {
	    // Write your code here.
	      int sum=0,end=0,start=0;
        
        for(int item:sweetness)
        {
            sum+=item;
        }
        end=sum/(K+1);
        
       return BinarySearch(start,end,sweetness,K+1);
    }
    int BinarySearch(int start,int end,int[] sweetness,int tar)
    {
        int ans = Integer.MAX_VALUE;
        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(Valid(mid,sweetness,tar))
            {
               ans=Math.min(ans,mid);
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
            
        }
        return end;
    }
    boolean Valid(int no,int[] sweetness,int tar)
    
    {
        int temp=0,ctr=0;
        for(int i=0;i<sweetness.length;i++)
        {
            temp+=sweetness[i];
            if(temp>=no)
            {
                ctr++;
                if(ctr>=tar)
                return true;
                temp=0;
            }
        }
        return false;
	}
}