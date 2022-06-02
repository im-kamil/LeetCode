class Solution {
    public int[][] transpose(int[][] matrix) {
      int R = matrix.length, C = matrix[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = matrix[r][c];
            }
        return ans;
    }
}