//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long findNumber(long N)
    {
        int a[]={1,3,5,7,9};
    String s="";
    long pre=1;
    long mul=5;
    int times=2;
    while(N>0){
        long temp=(N % mul)-1;
        long ind=(long)((temp+mul) %mul);
        int index=(int)(ind/pre);
        s=a[index]+s;
        N-=mul;
        mul=(long)Math.pow(5,times++);
        pre*=5;
    }
    return Long.parseLong(s); 
    }
}