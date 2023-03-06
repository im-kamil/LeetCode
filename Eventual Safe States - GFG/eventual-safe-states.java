//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> l=new ArrayList<>();

        boolean visit[]=new boolean[V];

        boolean path[]=new boolean[V];

        

        for(int i=0; i<V; i++){

         if(!visit[i]){

             dfs(i,adj,visit, path, l);

         } 

        }

        Collections.sort(l);

        return l;

    }

    boolean dfs(int x, List<List<Integer>> adj, boolean visit[], boolean path[], List<Integer> l){

        visit[x]=true;

        path[x]=true;

         for(int it:adj.get(x)){

             if(!visit[it]){

                 if(dfs(it,adj,visit,path,l))

                  return true;

             }else if(path[it]){

                 return true;

             }

         }

         

         path[x]=false;

         l.add(x);

         return false;
    }
}
