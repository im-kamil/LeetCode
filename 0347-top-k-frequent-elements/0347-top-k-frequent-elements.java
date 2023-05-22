class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        // build map<num, frequence>
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        // sort list from map.keyset() by map.get(num),
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
        // transfer results from list to int[];
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = list.get(i);
        
        return res;

    }
}