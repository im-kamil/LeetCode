//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] color = IntArray.input(br, N);
            
            
            int[] radius = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.finLength(N, color, radius);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int finLength(int n, int[] color, int[] radius) {
        // code here
        Stack <Integer> s1 = new Stack<>();
        Stack <Integer> s2 = new Stack<>();
        int i  = 0, j = 0;
        s1.add(color[i++]);
        s2.add(radius[j++]);
        while(i<n && j<n){
            int x = s1.pop();
            int y = s2.pop();
            if(x==color[i] && y==radius[j]){
                i++;
                j++;
            }
            else {
                s1.push(x);
                s1.push(color[i++]);
                s2.push(y);
                s2.push(radius[j++]);
            }
            if(s1.empty() && i<n){
                s1.push(color[i++]);
                s2.push(radius[j++]);
            }
        }
        int cc = 0;
        while(!s1.empty() && cc==0){
            int x = s1.pop();
            int y = s2.pop();
            if(s1.empty()){
                s1.push(x);
                cc = 1;
            }
            else{
                int kk = s1.pop() , pp = s2.pop();
                if(x==kk && y==pp)
                    continue;
                else{ 
                    s1.push(x);
                    s1.push(kk);
                    s2.push(y);
                    s2.push(pp);
                    cc = 1;
                }
            }
        }
        return s1.size();
    }
}
        
