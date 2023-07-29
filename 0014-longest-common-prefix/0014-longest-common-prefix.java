class Solution {
    public String common(String s1 , String s2){
        int n = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
            if(s1.charAt(i)==s2.charAt(i)) 
                sb.append(s1.charAt(i));
            else
                break;
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
//          Arrays.sort(strs);
        
//         String first=strs[0];
//         String second=strs[strs.length-1];
//         StringBuilder result=new StringBuilder();
        
        
//         for(int i=0;i<first.length();i++){
//             if(first.charAt(i)==second.charAt(i)) result.append(first.charAt(i));
//             else break;
//         }
//         return result.toString();
        String res = strs[0];
        for(int i=1;i<strs.length;i++){
            res = common(res, strs[i]);
        }
        return res;
    }
}