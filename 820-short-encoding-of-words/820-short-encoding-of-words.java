class Solution {
    public int minimumLengthEncoding(String[] words) {
         HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
		
        for(String word : words) {
            set1.add(word);
            set2.add(word);
        }
        
        for(String word : set1){
            for(int i = 0; i < word.length(); i++){
                String subString = word.substring(i + 1);
                if(set2.contains(subString)) set2.remove(subString);
            }
        }
        
        int totalCountOfCharacters = 0;
        for(String word : set2) totalCountOfCharacters += word.length();
        
        return totalCountOfCharacters + set2.size();
    }
}