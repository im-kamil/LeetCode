class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int valueLen = hay.length;
        int strLen = need.length;
        
        int max = valueLen - strLen;
        
        for(int i=0; i <= max; i++) {
            // Find the first character
            if(hay[i] != need[0]) {
                while(++i <= max && hay[i] != need[0]);
            }
            
            if(i <= max) {
                int k = i+1;
                int foundLength = i+strLen;
                for(int j=1; k<foundLength && needle.charAt(j) == hay[k]; j++, k++);
                if(k==foundLength) {
                    return i;
                }
            }
        }
        return -1;
    }
}