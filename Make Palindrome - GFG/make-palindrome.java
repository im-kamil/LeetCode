//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
         String s;
        HashSet<String> hs = new HashSet<>();
        int palCount=0;                        // for palindrome Strings
        
       for(int i=0;i<n;i++){
            
            s= getRev(arr[i]);
            if(hs.contains(arr[i])){
                if(s.equals(arr[i]))  palCount--;
                hs.remove(arr[i]);
            }else{
                if(s.equals(arr[i]))  palCount++;
                hs.add(s);
            }
        }
        
        if(palCount>1) return false;
        if(hs.size()>palCount) return false;
        return true;
        
    }
    

   public static String getRev(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
        
