class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int left = 0, right = costs.length - 1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (costs[a] - costs[b] != 0 ? costs[a] - costs[b] : a - b));
        for (int i = 0; i < candidates && left <= right; i++) {
            priorityQueue.add(left++);
            if (left <= right) priorityQueue.add(right--);
        }

        long res = 0;
        while (k > 0) {
            int idx = priorityQueue.poll();
            if (left <= right && left < costs.length && right >= 0) {
                if (idx <= left) priorityQueue.add(left++);
                else priorityQueue.add(right--);
            }
            res += costs[idx];
            k--;
        }
        return res;
    }
}