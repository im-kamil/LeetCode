class CountIntervals {
 TreeMap<Integer, Integer> m = new TreeMap<>();
    int cnt = 0;
    public void add(int left, int right) {
        var it = m.floorEntry(left);
        if (it == null || it.getValue() < left)
            it = m.higherEntry(left);
        for (; it != null && it.getKey() <= right; it = m.higherEntry(left)) {
            left = Math.min(left, it.getKey());
            right = Math.max(right, it.getValue());
            cnt -= it.getValue() - it.getKey() + 1;
            m.remove(it.getKey());
        }
        m.put(left, right);
        cnt += right - left + 1;        
    }
    public int count() { return cnt; }
    }


/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */