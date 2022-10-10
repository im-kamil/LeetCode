class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ch = palindrome.toCharArray(); 
        int n = ch.length/2;
        
        for (int i = 0; i < n; i++) {
            
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        
        if (palindrome.length() > 1) {
            ch[ch.length - 1] = 'b';
            return String.valueOf(ch);
        }
        
        return "";
    }
}