class Solution {
    public String longestPalindrome(String s) {
//         int n = s.length();
//   String res = null;
    
//   boolean[][] dp = new boolean[n][n];
    
//   for (int i = n - 1; i >= 0; i--) {
//     for (int j = i; j < n; j++) {
//       dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            
//       if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
//         res = s.substring(i, j + 1);
//       }
//     }
//   }
    
//   return res;
         int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);
            int len = Math.max(odd, even);
            if(len > end-start){
                //Even len (6)-> 2 start --> i-2, end -> i+3
                //Odd len (5) -> 2 start i-2, end -> i+2
                start = i - (len-1)/2;
                end = i+ len/2;
            }
        }
        return s.substring(start, end+1);
    }
    int expand(String s, int left, int right){
        while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}