class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
         Arrays.sort(edges, (a, b) -> (b[0] - a[0]));
        int[] roots1 = new int[n + 1];
        int[] roots2 = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            roots1[i] = i;
            roots2[i] = i;
        }
        int n1 = n, n2 = n; // Number of components for two players.
        int res = 0;
        for(int[] e : edges) {
            if(e[0] == 1) {
                int root_a = find(e[1], roots1);
                int root_b = find(e[2], roots1);
                if(root_a == root_b) { // If roots are the same, then this is a redundant edge and can be removed.
                    res++;
                } else {
                    roots1[root_a] = root_b; // If roots are different, we connect two different components.
                    n1--;
                }
            } else if(e[0] == 2) {
                int root_a = find(e[1], roots2);
                int root_b = find(e[2], roots2);
                if(root_a == root_b) {
                    res++;
                } else {
                    roots2[root_a] = root_b;
                    n2--;
                }
            } else {
                int root_a1 = find(e[1], roots1);
                int root_b1 = find(e[2], roots1);
                int root_a2 = find(e[1], roots2);
                int root_b2 = find(e[2], roots2);
                if(root_a1 != root_b1) {
                    roots1[root_a1] = root_b1;
                    n1--;
                }
                if(root_a2 != root_b2) {
                    roots2[root_a2] = root_b2;
                    n2--;
                }
                if(root_a1 == root_b1 && root_a2 == root_b2) {
                    res++;
                }
            }
        }
        if(n1 != 1 || n2 != 1) return -1; // If total number of components is not one for either players, return -1.
        return res;
    }
    
    private int find(int i, int[] roots) {
        int j = i;
        while(roots[i] != i) {
            i = roots[i];
        }
        roots[j] = i;
        return i;
    }
}