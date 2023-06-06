class Solution {
    public String reverseWords(String s) {
        // store in array // reverse the loop // use trim function
        // use StringBuilder when modifiy the String
        String[] words = s.split( " +");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length-1; i>=0; i--){
           sb.append(words[i]);
           sb.append(" ");
        }
        return sb.toString().trim();
    }
}