//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete{
    
    static int f=0;
    static ArrayList<Integer> a;
    public static void precompute()
    {
        a=new ArrayList<>();
        int N=1299709;
        int b[]=new int[N+1];
        for(int i=2;i<=N && i*i<=N;i++)
        {
            if(b[i]==0)
            {
                for(int j=i*i;j<=N;j+=i)
                b[j]=1;
            }
        }
        for(int i=2;i<=N;i++)
        {
            if(b[i]==0)
            a.add(i);
        }
    }
    public static void precompute (ArrayList<ArrayList<Integer>> adj,boolean vis[],int src) 
    {
        vis[src]=true;
        f++;
        for(int x: adj.get(src))
        {
            if(!vis[x])
            precompute(adj,vis,x);
        }
        //Complete the function
    }
    // Function for finding maximum and value pair
    public static int helpSanta (int n, int m, int g[][]) 
    {
        if(m==0)
        return -1;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            adj.get(g[i][0]-1).add(g[i][1]-1);
            adj.get(g[i][1]-1).add(g[i][0]-1);
        }
        int max=Integer.MIN_VALUE;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            f=0;
            if(!vis[i])
            {
            precompute(adj,vis,i);
            if(f>max)
            max=f;
            }
        }
        return a.get(max-1);// This line should never be reached
    
    }
}