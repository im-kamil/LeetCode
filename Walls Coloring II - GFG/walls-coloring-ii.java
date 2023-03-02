//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int N = costs.length;
    int K = costs[0].length;
    int INF = 1_000_000_000; // a very large number

    int prevMinCost = 0;
    int prevSecondMinCost = 0;
    int prevMinColor = -1;

    for (int i = 0; i < N; i++) {
        int currMinCost = INF;
        int currSecondMinCost = INF;
        int currMinColor = -1;

        for (int j = 0; j < K; j++) {
            int cost = costs[i][j];
            if (i == 0) {
                // initialize prevMinCost and prevSecondMinCost
                if (cost != 0 && cost < currMinCost) {
                    currSecondMinCost = currMinCost;
                    currMinCost = cost;
                    currMinColor = j;
                } else if (cost != 0 && cost < currSecondMinCost) {
                    currSecondMinCost = cost;
                }
            } else {
                // update dp[i][j]
                if (j != prevMinColor) {
                    cost += prevMinCost;
                } else {
                    cost += prevSecondMinCost;
                }
                if (cost != 0 && cost < currMinCost) {
                    currSecondMinCost = currMinCost;
                    currMinCost = cost;
                    currMinColor = j;
                } else if (cost != 0 && cost < currSecondMinCost) {
                    currSecondMinCost = cost;
                }
            }
        }

        // update prevMinCost and prevSecondMinCost
        prevMinCost = currMinCost;
        prevSecondMinCost = currSecondMinCost;
        prevMinColor = currMinColor;
    }

    // check if it is possible to color all the walls
    if (prevMinCost == INF) {
        return -1;
    } else {
        return prevMinCost;
	}
}
}