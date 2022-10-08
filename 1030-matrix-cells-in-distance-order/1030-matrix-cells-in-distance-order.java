class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[] counter = new int[R + C + 1];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dist = Math.abs(r - r0) + Math.abs(c - c0);
                counter[dist + 1] += 1;
            }
        }
        
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        
        int[][] ans = new int[R * C][];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dist = Math.abs(r - r0) + Math.abs(c - c0);
                ans[counter[dist]] = new int[] { r, c };
                counter[dist]++;
            }
        }
        
        return ans;
    }
}