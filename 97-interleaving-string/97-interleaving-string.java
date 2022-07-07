class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		 Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return isInterleave(s1, s2, s3, 0, 0, 0, dp);
    }

    public boolean isInterleave(String s1, String s2, String s3, int idx1, int idx2, int idx3, Boolean[][] dp) {

        if(dp[idx1][idx2] != null) return dp[idx1][idx2];
        
        if (idx3 == s3.length() && idx1 == s1.length() && idx2 == s2.length()) return true;

        if (idx1 < s1.length()  && idx3 < s3.length()  && s3.charAt(idx3) == s1.charAt(idx1)) {
            boolean result = isInterleave(s1, s2, s3, idx1 + 1, idx2, idx3 + 1, dp);
            dp[idx1][idx2] = result;
            if (result) return dp[idx1][idx2];
        }

        if (idx2 < s2.length() && idx3 < s3.length()  && s3.charAt(idx3) == s2.charAt(idx2)) {
            boolean result = isInterleave(s1, s2, s3, idx1, idx2 + 1, idx3 + 1, dp);
            dp[idx1][idx2] = result;
            if (result) return dp[idx1][idx2];
        }
        
        dp[idx1][idx2] = false;

        return dp[idx1][idx2];
    }
}