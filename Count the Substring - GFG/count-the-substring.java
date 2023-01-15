//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    } 

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            String S = sc.next();
            Solution ob = new Solution();
            long ans = ob.countSubstring(S);
            out.println(ans);
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long countSubstring(String S){
          long res=0;

   HashMap<Long,Integer> hm=new HashMap<>();

   long[] dp=new long[S.length()];

   long sum=-1;

   if(S.charAt(0)=='1'){

    dp[0]=1;

    res=1;

    sum=1;

   }

  hm.put(sum,0);

  hm.put((long) 0,-1);

  for(int i=1;i<S.length();i++){

    long tt=0;

    if(S.charAt(i)=='0'){

      sum-=1;

    }

    else{

      sum+=1;

    }

    if(S.charAt(i)=='0'){

      if(hm.containsKey(sum)){

        if(hm.get(sum)!=-1){

          tt+=dp[hm.get(sum)];

        }

      }

    }

    else{

      if(hm.containsKey(sum)){

        if(hm.get(sum)!=-1){

          tt=tt+dp[hm.get(sum)]+i-hm.get(sum)-1;

        }

        else{

          tt=tt+i-hm.get(sum)-1;

        }

      }

      else{

        tt+=i+1;

      }

 

    }

    hm.put(sum,i);

    dp[i]=tt;

    res+=tt;

  }

  return res;
    }
}