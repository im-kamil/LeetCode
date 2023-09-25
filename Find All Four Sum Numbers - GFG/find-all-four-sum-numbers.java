//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
          int n=arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> aa= new ArrayList<>();
        HashSet<ArrayList<Integer>> hs= new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                int s=j+1,e=n-1;
                int sum=0;

                while(s<e){
                    sum=arr[i]+arr[j]+arr[s]+arr[e];
                    
                    if(sum<k) s++;
                    else if(sum>k) e--;
                    else{
                        
                        ArrayList<Integer> a1= new ArrayList<>();
                        a1.add(arr[i]); a1.add(arr[j]);a1.add(arr[s]);a1.add(arr[e]);
                        if(!hs.contains(a1)){
                            aa.add(a1);
                            hs.add(a1);
                        }
                        s++;
                        e--;
                    }
                    
                }
            }

        }
        
        return aa;
    }
}