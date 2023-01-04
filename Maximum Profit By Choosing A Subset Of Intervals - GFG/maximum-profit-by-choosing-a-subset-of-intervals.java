//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maximum_profit(int n, int[][] arr) {
        // code here
          Arrays.sort(arr,(a,b)->{

            if(a[0]!=b[0])

                return a[0]-b[0];

            return a[1]-b[1];

        });

        int[]dp = new int[n];

        return rec(0,arr,n,dp);

    }

    static int rec(int index,int[][]arr,int n,int[]dp){

        if(index>=n)

            return 0;

        if(dp[index]!=0)

            return dp[index];

        int not_select = rec(index+1,arr,n,dp);

        int nextIndex = findNext(index+1,arr[index][1],arr,n);

        int select = arr[index][2] + rec(nextIndex,arr,n,dp);

        return dp[index] = Math.max(select,not_select);

    }

    static int findNext(int i,int prevEnd,int[][]arr,int n){

        while(i<n){

            if(arr[i][0]>=prevEnd){

                break;

            }

            else{

                i++;

            }

        }

        return i;

    
    }
}
