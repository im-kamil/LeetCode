class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        //no paths to destination as the starting point has obstacle in it
        if(obstacleGrid[0][0] == 1) return 0;
        
        //No of ways reaching to starting point shoudl be 1
        obstacleGrid[0][0] = 1;
        
        //filling the rows for first column
        for(int i = 1; i < m; i++) {
            //if current and prev both are reachable (no obstacle) then make current as 1
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
        }
        
        //filling the columns for first row
        for(int i = 1; i < n; i++) {
            //if current and prev both are reachable (no obstacle) then make current as 1
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        
        return obstacleGrid[m-1][n-1];
    }
}