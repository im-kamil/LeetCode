class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int n=colors.length();
        char[] color=colors.toCharArray();
        
        for(int i=0;i<n;i++) graph.add(i,new ArrayList<>());
        int[] indegree=new int[n];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            indegree[v]++;
            graph.get(u).add(v);
        }
        
		//2. color count map. map[i][j] is the maximum count of j-th color from the ancester nodes to node i
        int[][] map=new int[n][26]; 
        
		//3.Khans Algorithm ( Iterative Topological Sort)
        Queue<Integer> que=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                que.add(i);
                map[i][color[i]-'a']=1;
            }
        }
        
        int res=0;
        int seen=0;
        
        while(que.size()>0){
            int node=que.remove();
            seen++;
            
            int max=getMax(map[node]);
            res=Math.max(res,max);
            
            for(int nbr:graph.get(node)){
                // update the map of next node
                for(int i=0;i<26;i++){
                    map[nbr][i]=Math.max(map[nbr][i],map[node][i] + (color[nbr]-'a'==i?1:0));
                }
                indegree[nbr]--;
                
                if(indegree[nbr]==0){
                    que.add(nbr);
                }
            }
        }
        //if seen!=n means cycle is there
        return seen==n?res:-1;
    }
    
    private int getMax(int[] num){
        int max=num[0];
        for(int n:num){
            max=Math.max(n,max);
        }
        return max;
    }
}