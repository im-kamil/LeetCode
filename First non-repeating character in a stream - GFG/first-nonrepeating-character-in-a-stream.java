//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
         int freq[] = new int[26];

        String res="";

        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<A.length();i++)

        {

            char ch=A.charAt(i);

            q.add(ch);

            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1)

            {

                q.remove();

            }

            if(q.isEmpty())

            {

                res+='#';

            } else {

                res+=q.peek();

            }

        }

        return res;
    }
}