class Solution {
    public List<Integer> goodIndices(int[] a, int k) {
        int n= a.length;
        int[] dp1= new int[n+1];  Arrays.fill(dp1,1);
        int[] dp2= new int[n+1];  Arrays.fill(dp2,1);   
        List<Integer> ans= new ArrayList<>();
        
        for(int i=1;i<n;i++)  
            if(a[i-1]>=a[i]) dp1[i]= dp1[i-1]+1;
        
        for(int i=n-2;i>=0;i--)
            if(a[i]<=a[i+1]) dp2[i]= dp2[i+1]+1;
        
        for(int i=k;i<n-k;i++)
            if(dp1[i-1]>=k && dp2[i+1]>=k) ans.add(i);
        return ans;
    }
}