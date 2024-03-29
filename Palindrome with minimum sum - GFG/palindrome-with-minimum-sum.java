//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int frontChar(String s,int n){
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='?') return i;
        }
        return -1;
    }
    private static int backChar(String s,int n){
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!='?') return i;
        }
        return -1;
    }
    private static int solve(String s){
        int n,ans,x,y;
        char prev;
    
        ans=0;
        n=s.length();
        x=frontChar(s,n);
        y=backChar(s,n);
        
        //base case
        if(x==-1 || x==y) return 0;
    
        if(x<=n-y-1){
            prev=s.charAt(x);
        }
        else{
            prev=s.charAt(y);
        }
        
    
        for(int i=Math.min(x,n-y-1),j=n-i-1;i<j;i++,j--){
            char tf=s.charAt(i);
            char tb=s.charAt(j);
    
            if(tf=='?' && tb=='?'){
                continue;
            }
            else if(tf=='?'){
                ans+=Math.abs((int)(tb-prev));
                prev=tb;
            }
            else if(tb=='?'){
                ans+=Math.abs((int)(tf-prev));
                prev=tf;
            }
            else if(tf==tb && tf!='?'){
                ans+=Math.abs((int)(prev-tf));
                prev=tf;
            }
            else{
                return -1;
            }
    
        }
    
        return 2*ans;
    }
    public static int minimumSum(String s) {
        // code here
        return solve(s);
        
    }
}
