//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int n, int len[] ,int qty[]) { 
        // code here
        int min = Integer.MAX_VALUE;
       long sum = 0;
       for(int i = 0;i<n;i++){
           if(qty[i] >=4 ){
               min = Math.min(min, len[i]);
               sum += (qty[i]/4)*len[i]*4;
               qty[i] %= 4;
           }
       }
      int cnt = 0;
      for(int i = 0;i<n;i++){
          if(qty[i] >=2 ){
              min = Math.min(min, len[i]);
              cnt += 1;
              sum += len[i]*2;
              qty[i] %= 2;
          }
      }
    //   System.out.println(min);
      if(cnt%2 != 0) sum -= min*2;
        return sum;
    }
} 