//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int distance;
    public Pair(int distance, int node){
        this.node = node;
        this.distance = distance;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	     ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<Pair>());
        
        for(int i[]:edges)
        {
            int u=i[0];
            int v=i[1];
            int d=i[2];
            adj.get(u).add(new Pair(d,v));
            adj.get(v).add(new Pair(d,u));
        }
        
        int sum=0;
        
        int[] vis=new int[V];
       
        
        PriorityQueue<Pair> uwu=new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        uwu.add(new Pair(0,0));
        
        while(!uwu.isEmpty())
        {
            int node=uwu.peek().node;
            int dis=uwu.peek().distance;
            uwu.poll();
            if(vis[node]==1)
            continue;
            sum+=dis;
            vis[node]=1;
            
            for(Pair i:adj.get(node))
            {
                int newnode=i.node;
                int newdis=i.distance;
                
                if(vis[newnode]==0)
                uwu.add(new Pair(newdis, newnode));
            }
        }
        return sum;
	}
}