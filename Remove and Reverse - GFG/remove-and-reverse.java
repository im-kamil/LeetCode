//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        // code here
         HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=S.length()-1;
        boolean rev = false;
        HashSet<Integer> del = new HashSet<>();
        
        for(char ch : S.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        while(i<j){
            char first = S.charAt(i);
            char last = S.charAt(j);
            
            if(!rev){
                if(map.get(first) > 1){
                    map.put(first, map.get(first)-1);
                    del.add(i);
                    rev = !rev;
                }
                i++;
            } else {
                if(map.get(last) > 1){
                    map.put(last, map.get(last)-1);
                    del.add(j);
                    rev = !rev;
                }
                j--;
            }
        }
        StringBuilder ans = new StringBuilder();
        
        for(i=0; i<S.length(); i++){
            if(!del.contains(i)) ans.append(S.charAt(i));
        }
        if(rev) return ans.reverse().toString();
        
        return ans.toString();
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends