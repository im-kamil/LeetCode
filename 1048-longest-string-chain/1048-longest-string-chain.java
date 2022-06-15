class Solution {
    public int longestStrChain(String[] words) {
         Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            dp.put(word, 1);
        }
    
        int max = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {   // delete one char from current word to find the previous string
                String prev = word.substring(0, i) + word.substring(i+1);
                if (dp.containsKey(prev)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
                }
            }
            max = Math.max(max, dp.get(word));
        }
        return max;
    }
}