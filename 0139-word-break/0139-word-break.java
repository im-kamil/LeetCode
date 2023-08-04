class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       // for memoization
        HashMap<String,Boolean> map= new HashMap<>();
        return canConstruct(s, wordDict, map);
    }
    
    public boolean canConstruct(String target,List<String> words, HashMap<String,Boolean> map)
    {
	
	// if answer already cached, return it
        if(map.containsKey(target))
            return map.get(target);
			
		// if target string is empty
		// it can always be constructed by taking no elements from dictionary
        if(target.isEmpty())
            return true;
			
		// for all words in the dictionary
        for(String word: words)
        {
		// if the target starts with the given word
            if(target.startsWith(word))
            {
			// and it is possible to construct the rest of the string
			// from the words in the dictionary
                if(canConstruct(target.substring(word.length()),words, map))
                {
				
				// save and return true
                    map.put(target, true);
                    return true;
                }
            }
        }
		
		// if it was not possible to construct the target from words from the dictionary
		// save and return false to the previous call
        map.put(target,false);
        return false;
    }
}