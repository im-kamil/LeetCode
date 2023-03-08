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
			int N, K, W;
			String [] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			str = br.readLine().trim().split(" ");
			int [] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.maximizeMinHeight(N, K, W,arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	long maximizeMinHeight(int n, int k, int w,int [] a)
    {
        //Write your code here
         long left = Arrays.stream(a).min().getAsInt();

        long right = left + k + 1;

        while (left < right) {

            long mid = (left + right + 1) / 2;

            if (canAchieveMinHeight(mid, a, k, w)) {

                left = mid;

            } else {

                right = mid - 1;

            }

        }

        return left;

    }

 

    boolean canAchieveMinHeight(long minHeight, int[] a, int k, int w) {

        long[] mods = new long[a.length];

        long add = 0;

        for (int i = 0; i < a.length; i++) {

            add += mods[i];

            long v = a[i] + add;

            if (v < minHeight) {

                long delta = minHeight - v;

                if (delta > k) {

                    return false;

                }

                if (i + w < a.length) {

                    mods[i + w] -= delta;

                }

                add += delta;

                k -= delta;

            }

        }

        return true;
    }
    }
