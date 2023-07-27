class Solution {
    public int uniquePaths(int m, int n) {
    //     int[][] grid = new int[m][n];
    // for(int i = 0; i<m; i++){
    //     for(int j = 0; j<n; j++){
    //         if(i==0||j==0)
    //             grid[i][j] = 1;
    //         else
    //             grid[i][j] = grid[i][j-1] + grid[i-1][j];
    //     }
    // }
    // return grid[m-1][n-1];
        // most optimal soultions  by formula
        int N = n+m-2;
        int r = m-1;
        double ans = 1;
        for(int i=1;i<=r;i++){
            ans = ans*(N-r+i)/i;
        }
        return (int) ans;
    }
}