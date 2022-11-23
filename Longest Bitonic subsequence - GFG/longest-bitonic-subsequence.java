//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        if(nums.length==1)

            return 1;

        ArrayList<Integer> firstLis = new ArrayList<>();

        ArrayList<Integer> secondLis = new ArrayList<>();

        int n = nums.length;

        function(nums,firstLis);

        int ii = 0;

        int jj = n-1;

        while(ii<jj){

            int temp = nums[ii];

            nums[ii] = nums[jj];

            nums[jj] = temp;

            ii++;jj--;

        }

       function(nums,secondLis);

       Collections.reverse(secondLis);

       int max = (int)-1e9;

    //   System.out.println(firstLis);

    //   System.out.println(secondLis);

       for(int i=0;i<firstLis.size();i++){

           max = Math.max(max,Math.abs(firstLis.get(i)+secondLis.get(i)));

       }

      

       return max-1;

        

    }

    

    public ArrayList<Integer> function(int [] arr,ArrayList<Integer> lis){

        ArrayList<Integer> al = new ArrayList<Integer>();

        al.add(arr[0]);

        for(int i=1;i<arr.length;i++){

            if(arr[i]>al.get(al.size()-1)){

                al.add(arr[i]);

            }

            else{

                findGoodPlace(al,arr[i]);

            }

         lis.add(al.size());   

        }

        return lis;

    }

    

    public void findGoodPlace(ArrayList<Integer> al,int ele){

        int low = 0;

        int high = al.size()-1;

        

        while(low<=high){

            int mid = (low+high)/2;

            if(al.get(mid)==ele)

            {

                break;

            }

            else if(al.get(mid)<ele){

                low = mid+1;

            }else if(al.get(mid)>ele){

                high = mid-1;

            }

        }

        if(low>high){

            al.set(low,ele);

        }

    
    }
}