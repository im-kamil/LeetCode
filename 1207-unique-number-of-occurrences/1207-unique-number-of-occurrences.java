class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //  HashMap<Integer,Integer> cnt = new HashMap<>();
        // for (int n : arr) cnt.put(n, cnt.getOrDefault(n, 0)+1);
        // HashSet<Integer> unq = new HashSet<>(cnt.values());
        // return unq.size() == cnt.size();
          // Store the frequency.
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Check the count and insert in a hash set.
        Set<Integer> set = new HashSet<>();
        for (int freq : mp.values()) {
            set.add(freq);
        }

        // If the size of the map is the same as the set, that means all frequencies are unique.
        return set.size() == mp.size();
    }
}