class Solution {
    public String sortSentence(String s) {
//         String[] str = s.split(" ");
//         String[] arr = new String[str.length];
//         for(String t:str){
//         int n = t.length();
//         int pos = t.charAt(n-1)-48;
//         arr[pos-1] = t.substring(0, n-1);
//            StringBuilder sb = new StringBuilder();
//             for(String t:arr){
//                 sb.append(t);
//                 sb.append(" ");
//             }
//             return sb.toString().trim();
    
//     }
         String[] words = s.split(" "), ans = new String[words.length];
        for (String word : words) {
            int i = word.length() - 1;
            ans[word.charAt(i) - '1'] = word.substring(0, i);
        }
        return String.join(" ", ans);
}
}