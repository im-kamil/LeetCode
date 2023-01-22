//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> rk=new Stack<>();

        char[]r=new char[s.length()];

        for(int i=0;i<s.length();i++){

            r[i]=s.charAt(i);

        }

        

        for(int j=0;j<s.length();j++){

        

            if(rk.isEmpty() ){

              rk.push(r[j]);

            }else if(rk.peek()==r[j]){

                rk.pop();

            }else{

                rk.push(r[j]);

            }

        }

        if(rk.isEmpty()){

            return "-1";

        }

        String f="";

         Iterator value = rk.iterator();

          while (value.hasNext()) {

        f+=  value.next();

          }

        return f;
    }
}
        
