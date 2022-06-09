class Solution {
    public int removePalindromeSub(String s) {
        if(s.isBlank()) return 0;
        if(isPalindrom(s)){
            return 1;
        }
        return 2;
    }
    boolean isPalindrom(String s){
        int left = 0,right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}