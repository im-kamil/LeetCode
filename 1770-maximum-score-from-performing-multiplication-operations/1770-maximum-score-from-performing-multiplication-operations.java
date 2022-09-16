class Solution {
        int n, m;  // muls - multipliers
    int[] nums, muls;
    Integer[][] memo;
    public int maximumScore(int[] nums, int[] muls) {
        n = nums.length;
        m = muls.length;
        this.nums= nums;
        this.muls = muls;
        this.memo = new Integer[m][m];
        return dp(0, 0);
    }
    private int dp(int l, int i) {
        if (i == m) return 0; // Picked enough m elements
        if (memo[l][i] != null) return memo[l][i];
        int pickLeft = dp(l+1, i+1) + nums[l] * muls[i]; // Pick the left side
        int pickRight = dp(l, i+1) + nums[n-(i-l)-1] * muls[i]; // Pick the right side
        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}