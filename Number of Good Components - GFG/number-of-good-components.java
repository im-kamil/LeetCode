//{ Driver Code Starts
// Initial Template for Java

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
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean flag = true;
    public int findNumberOfGoodComponent(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         boolean visited[]=new boolean [v+1];

        int count=0;

      

        for(int i=1;i<=v;i++)

        {

            if(visited[i]==false)

            {

            ArrayList<Integer>temp=new ArrayList<Integer>();

             flag=true;

            temp.add(i);

            dfs(i,adj,visited,temp);

            if(flag==true)

            count++;

            }

        }

        return count;

    }

    public void dfs(int vertex,ArrayList<ArrayList<Integer>> adj,boolean visited[],ArrayList<Integer>temp)

    {

        visited[vertex]=true;

        ArrayList<Integer>a=adj.get(vertex);

        for(int i:a)

        {

            if(visited[i]==false)

            {

                temp.add(i);

                dfs(i,adj,visited,temp);

            }

        }

        if(adj.get(vertex).size()+1!=temp.size())

        flag=false;

        

    
    }
}