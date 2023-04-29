class Solution {
     public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    // DISJOINT SET

    Map<int[], Integer> original = new IdentityHashMap<>();
    for (int i = 0; i < queries.length; i++) {
      original.put(queries[i], i);
    }
    
    
    // start with smaller queries then union allowed edges and so on
    parent = IntStream.rangeClosed(0, n).toArray();

    Map<Integer, Boolean> result = new HashMap<>();
    Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
    Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
    int qI = 0;
    int eI = 0;
    for (; qI < queries.length; qI++){
      int[] query = queries[qI];
      while (eI < edgeList.length && edgeList[eI][2] < query[2]){
        union(edgeList[eI][0], edgeList[eI][1]);
        eI++;
      }
      result.put(qI, find(query[0]) == find(query[1]));
    }


    boolean[] r= new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
      r[original.get(queries[i])] = result.get(i);
    }
    return r;

  }
  
  private int[] parent;

  private void union(int a, int b) {
    parent[find(a)] = find(b);
  }

  private int find(int a) {
    if (a != parent[a]) {
      parent[a] = find(parent[a]);
    }
    return parent[a];
    }
}