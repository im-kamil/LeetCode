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
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
 HashSet<String> set;

    int[][] grid;

    StringBuilder struct;
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        this.set = new HashSet<>();

        this.grid = grid;

        for(int i = 0 ; i < grid.length ; i++){

            for(int j = 0; j < grid[i].length ; j++){

                if(grid[i][j] == 1){

                    this.struct = new StringBuilder();

                    dfs(i , j , 'x');

                    this.set.add(struct.toString());

                }

            }

        }

        return set.size();

    }

    

    void dfs(int r , int c , char ch){

        if(r < 0 || r > grid.length-1 || c < 0 || c > grid[r].length-1 || grid[r][c] == 0)return ;

        

        grid[r][c] = 0;

        this.struct.append(ch);

        dfs(r+1 , c , 'n');

        this.struct.append(ch);

        dfs(r , c+1 , 'e');

        this.struct.append(ch);

        dfs(r-1 , c , 's');

        this.struct.append(ch);

        dfs(r , c-1 , 'w');

        this.struct.append(ch);

        

        return;
        
    }
}
