//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        Arrays.sort(arr);
        int a = arr[0];
        int count =-1;
        for(int i =1;i<n;i++)
        {
            if(arr[i] == a)
            {
                count++;
            }
            else
            {
                if(count >= 0){
                    al.add(arr[i-1]);
                }
                count=-1;
                a = arr[i];
            }
        }
        if(count != -1)
        {
            al.add(arr[n-1]);
        }

        if(al.size()==0)
        {
            al.add(-1);
        }
        return al;
    }
}
