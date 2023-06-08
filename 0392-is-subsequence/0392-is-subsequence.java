class Solution {
    public boolean isSubsequence(String s, String t) {
         if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
        // if(s.length()==0) return true;
        // int i=0;
        // int j=0;
        // while(i<s.length()&&i<t.length()){
        //     if(s.charAt(i)==t.charAt(j)){
        //         i++;
        //         j++;
        //     }else{
        //         j++;
        //     }
        // }
        // if(i==s.length()){
        //     return true;
        // }
        // return false;
    }
}