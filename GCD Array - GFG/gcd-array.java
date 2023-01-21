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
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, K, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int N, int K, int[] arr) {
        // code here
         int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 1; i * i <= sum; i++) {
            if (sum % i == 0) {
                v.add(sum / i);
                if (i * i != sum) {
                    v.add(i);
                }
            }
        }
        Collections.sort(v, Collections.reverseOrder());
        int cnt;
        int ans = 1;
        sum = 0;
        for (int i = 0; i < v.size(); i++) {
            int x = v.get(i);
            cnt = 0;
            sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[j];
                if (sum % x == 0) {
                    cnt++;
                    sum = 0;
                }
            }
            if (cnt >= K) {
                return v.get(i);
            }
        }
        return ans;
    }
}
        
