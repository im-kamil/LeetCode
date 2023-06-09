//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
      public static void reverse(ArrayList<Character>l,int idx1,int idx2)
    {
        while(idx1<idx2)
        {
            char temp=l.get(idx1);
            l.set(idx1,l.get(idx2));
            l.set(idx2,temp);
            idx1++;
            idx2--;
            
        }
    }
    public static void swap(ArrayList<Character>l,int idx1,int idx2)
    {
            char temp=l.get(idx1);
            l.set(idx1,l.get(idx2));
            l.set(idx2,temp);
            
    }
    public static void nextper(ArrayList<Character>l)
    {
        //String s="";
        int n=l.size();
        int idx1=-1;
        int idx2=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(l.get(i)<l.get(i+1))
            {
                idx1=i;
                break;
            }
        }
        if(idx1<0)
        {
            reverse(l,0,n-1);
        }
        else
        {
        for(int i=n-1;i>idx1;i--)
        {
            if(l.get(i)>l.get(idx1))
            {
                idx2=i;
                break;
            }
        }
        swap(l,idx1,idx2);
        reverse(l,idx1+1,n-1);
        }
    }
    public static String arrayListToString(ArrayList<Character> charList) {
        StringBuilder sb = new StringBuilder(charList.size());

        for (Character ch : charList) {
            sb.append(ch);
        }

        return sb.toString();
    }
    public List<String> find_permutation(String S) {
        // Code here
        ArrayList<Character>c=new ArrayList<>();
        ArrayList<String>l=new ArrayList<>();
        HashSet<String>h=new HashSet<>();
        for(int i=0;i<S.length();i++)
        {
            c.add(S.charAt(i));
        }
        int tp=1;
        int n=S.length();
        while(n>0)
        {
            tp=tp*n;
            n=n-1;
        }
        for(int i=0;i<tp;i++)
        {
            nextper(c);
            String str = arrayListToString(c);
            if(!l.contains(str))
            l.add(str);
        }
        Collections.sort(l);
        return l;
    }
}