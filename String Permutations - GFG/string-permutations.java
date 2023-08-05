//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
     public  void print(String str,String t,List<String>list){
        if(str.equals("")){
            list.add(t);
            return ;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String left=str.substring(0,i);
            String right=str.substring(i+1);
            String rem=left+right;
            print(rem,t+ch,list);
        }
    }
    public ArrayList<String> permutation(String s)
    {
        //Your code here
        ArrayList<String> list = new ArrayList<>();
        print(s,"",list);
        Collections.sort(list);
        return list;
        
    }
	   
}
