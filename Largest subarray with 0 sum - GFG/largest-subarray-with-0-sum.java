//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
          int sum = 0;

        int maxLength = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        for(int i=0;i<arr.length;i++){

            sum += arr[i];

            if(map.containsKey(sum)){

                int max = i - map.get(sum);

                maxLength = Math.max(maxLength,max);

            }else{

                map.put(sum,i);

            }

        }

        return maxLength;

 
    }
}