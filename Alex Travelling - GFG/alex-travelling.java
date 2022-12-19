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
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
         HashMap<Integer,ArrayList<Pair>> adjlist=new HashMap<>();

        

        for(int i  = 0 ; i < flights.length; ++i) {

            

            int u = flights[i][0];

            int v = flights[i][1];

            int w = flights[i][2];

            

            if(adjlist.containsKey(u)==false)

                adjlist.put(u,new ArrayList<Pair>());

            adjlist.get(u).add(new Pair(v,w));

        }

        int count=0;

        int vis[]=new int[n+1];

        Queue<Pair> q=new LinkedList<>();

        vis[k] = 0;

        q.add(new Pair(k,vis[k])); 

        int ans = Integer.MIN_VALUE;

        

        while(!q.isEmpty()) {

            Pair curr = q.peek();

            q.remove();

            

            int node = curr.to;

            int cost = curr.weight;

            

            if(adjlist.get(node)==null)continue;

            for(Pair x: adjlist.get(node)) {

                int node_x = x.to;

                int cost_x = x.weight;

                

                if(vis[node_x] == 0 && node_x!=k) {

                    count++;

                    vis[node_x] = cost + cost_x;

                    q.add(new Pair(node_x, vis[node_x]));

                }

                

                else if(vis[node_x] > cost + cost_x && node_x!=k) {

                    vis[node_x] = cost + cost_x;

                    q.add(new Pair(node_x, vis[node_x]));

                }

            }

        }

        

        for(int i = 1 ; i < vis.length; ++i) {

            if(vis[i] != 0) {

                ans = Math.max(ans, vis[i]);

            }

            else if(i!=k)return -1;

        }

        return ans;

    }

}

class Pair{

    int to;

    int weight;

    Pair(int to,int weight){

        this.to=to;
        this.weight = weight;
    }
}
