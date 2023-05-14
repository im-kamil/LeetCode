class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] seen = new boolean[n * n + 1];
        seen[1] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return steps;
                }
                int min = curr + 1;
                int max = Math.min(curr + 6, n * n);
                for (int next = min; next <= max; next++) {
                    int r = n - 1 - (next - 1) / n;
                    int c = r % 2 != n % 2 ? (next - 1) % n : n - 1 - (next - 1) % n;
                    int dest = board[r][c] != -1 ? board[r][c] : next;
                    if (!seen[dest]) {
                        queue.offer(dest);
                        seen[dest] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}