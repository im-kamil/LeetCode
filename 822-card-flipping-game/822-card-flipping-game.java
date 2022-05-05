class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int[] a = new int[2001];
        Arrays.fill(a, -1); 
        int n = fronts.length; 
        for(int i = 0 ; i < n; ++i){
            if(fronts[i] == backs[i])a[backs[i]] = 1;
            else{ 
                if(a[backs[i]] != 1)
                    a[backs[i]] = 0; 
                if(a[fronts[i]] != 1)
                    a[fronts[i]] = 0; 
            }
        }
        int ans = 0;
        for(int i = 1; i < a.length; ++i){
            if(a[i] == 0){
                ans = i; 
                break; 
            } 
        }
        return ans; 
    }
}