//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>> final_al=new ArrayList<ArrayList<String>> ();

        TreeMap<String,ArrayList<String>> map=new TreeMap<>();

        String start="";

        for(int i=0;i<s.length();i++){

            ArrayList<String> al=new ArrayList<>();

            start=start+s.charAt(i);

            for(int j=0;j<n;j++){

            if(contact[j].startsWith(start)){

                if(!al.contains(contact[j]))

                al.add(contact[j]);

            }

            }

            if(!al.isEmpty()){

                Collections.sort(al);

            map.put(start,al);

            }

            else{

                al.add("0");

            map.put(start,al);

            }

            //al.clear();

        }

       for(Map.Entry<String, ArrayList<String>> x: map.entrySet())

       final_al.add(x.getValue());

       

       return final_al;
    }
}