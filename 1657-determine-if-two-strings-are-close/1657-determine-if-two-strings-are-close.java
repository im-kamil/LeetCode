class Solution {
    public boolean closeStrings(String word1, String word2) {
       if(word1.length()!=word2.length()) return false;
        
        int[] w1=new int[26];
        int[] w2=new int[26];
        
        for(char c:word1.toCharArray()){
            w1[c-'a']++;
        }
        
        for(char c:word2.toCharArray()){
            w2[c-'a']++;
        }
        
        //Step1: 
        for(int i=0;i<26;i++){
            if((w1[i]==0 && w2[i]!=0) || (w1[i]!=0 && w2[i]==0)){
                return false;
            }
        }
        
        //Step 2:
//         Map<Integer,Integer> map=new HashMap<>();
        
//         for(int i:w1){
//             if(i>0){
//                 map.put(i,map.getOrDefault(i,0)+1);
//             }
//         }
        
//         for(int i:w2){
//             if(i>0){
//                 if(!map.containsKey(i)){
//                     return false;
//                 }
                
//                 map.put(i,map.get(i)-1);
//                 if(map.get(i)==0){
//                     map.remove(i);
//                 }
//             }
//         }
        
//         return map.size()==0;
        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1,w2);
    }
}