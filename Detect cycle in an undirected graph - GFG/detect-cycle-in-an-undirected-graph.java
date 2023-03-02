//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
//     public boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>>adj, boolean[] vis){
//         vis[src] = true;
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(src, -1));
//         while(!q.isEmpty()){
//             int node = q.peek().first;
//             int parent = q.peek().second;
//             q.remove();
//             for(int adjacentNode:adj.get(node)){
//                 if(vis[adjacentNode]==false){
//                     vis[adjacentNode]=true;
//                     q.add(new Pair(adjacentNode, node));
//                 }else if(parent!=adjacentNode){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         // Code here
//         boolean vis[] = new boolean[V];
//         for(int i=0;i<V;i++) vis[i]=false;
//         for(int i=0; i<V; i++){
//             if(vis[i]==false){
//                 if(checkForCycle(i, V, adj, vis)) return true;
//             }
//         }
//         return false;
        
//     }
// }
public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[v];
        
        for(int i=0; i < v ; i++){
            if(!vis[i]){
                if(dfs(adj,i,-1,vis))
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int curr,int parent,boolean vis[]){
        vis[curr] = true;
        
        for(int i=0; i < adj.get(curr).size() ; i++){
            int e = adj.get(curr).get(i);
            
            if(vis[e] && e != parent)
            return true;
            
            else if(!vis[e]){
                if(dfs(adj,e,curr,vis))
                return true;
            }
        }
        return false;
    }
}