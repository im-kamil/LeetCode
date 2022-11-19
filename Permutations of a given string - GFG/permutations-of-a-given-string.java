//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 

    public static void solve(String s1, int i, HashSet<String> hs) {
        //base case
        if(i == s1.length()) {
            hs.add(s1.toString());
            return;
        }

        for(int j = i; j < s1.length(); j++) {
            s1 = swap(s1, i, j);
            solve(s1, i + 1, hs);
            s1 = swap(s1, i, j);
        }
    }
    
    public List<String> find_permutation(String S) {
        // Code here
        HashSet<String> hs = new HashSet<>();
        solve(S, 0, hs);
        ArrayList<String> output = new ArrayList<>(hs);
        Collections.sort(output); 
        return output;
    }
}
