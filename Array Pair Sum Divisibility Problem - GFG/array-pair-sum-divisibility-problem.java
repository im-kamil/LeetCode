//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
         int n = nums.length;

       

       if((n&1)== 1)return false;

       

       HashMap<Integer, Integer> map = new HashMap<>();

       

      for(int i = 0; i< n ; i++){

          nums[i] = nums[i]%k;

          map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

      }

      if(map.containsKey(0))

      if((map.get(0)&1)== 1)return false;

      

       for(int i = 0; i<n; i++){

          if(nums[i]== 0)continue;

          if(!(map.get(nums[i]) == map.get(k-nums[i])))return false;

       }

       return true;
    }
}