class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
         List<Integer>[] al = new ArrayList[n];
        for(int i=0;i<n;i++) al[i] = new ArrayList<>();
        for(int e[] : edges){
            al[e[0]].add(e[1]); al[e[1]].add(e[0]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i : restricted) set.add(i);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);  set.add(0);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                ans++;
                int curr = q.remove();
                for(int next : al[curr]) 
                    if(set.add(next)) q.add(next);
            }
        }
        return ans;
    }
}