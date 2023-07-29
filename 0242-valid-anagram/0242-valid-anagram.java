class Solution {
    public boolean isAnagram(String s, String t) {
        //  int[] alphabet = new int[26];
        // for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        // for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        // for (int i : alphabet) if (i != 0) return false;
        // return true;
        if(s.length()!=t.length()) return false ;
        int [] count = new int[26];
        for(char ch : s.toCharArray())
             count[ch-97]++;
        for(char ch : t.toCharArray())
             count[ch-97]--;
        for(int val:count) 
            if(val!=0) return false;
        return true;
    }
}