//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int n, int groupSize, int hand[]) {
        // code here
        if(n%groupSize!=0) return false;
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i:hand){
            tm.put(i,tm.getOrDefault(i,0)+1);
        }
     
        while(!tm.isEmpty()){
            int curr=tm.firstKey(),freq=tm.get(curr);
           for(int j=1;j<groupSize;j++){

// getting the next consecutive number 
               int cons=curr+j;

// checking if map contains cons
               if(!tm.containsKey(cons)){
                   return false;
               }else{

// checking if the frequency of cons is less than curr number 
// if yes we can return false

                if(tm.get(cons)<freq) return false;
                tm.put(cons,tm.get(cons)-freq);
                 if(tm.get(cons)==0) tm.remove(cons);
               }
           }

//removing the curr element from map as all pairs that can be      made using this are made

            tm.remove(curr);
        }
        return true;
    }
}
