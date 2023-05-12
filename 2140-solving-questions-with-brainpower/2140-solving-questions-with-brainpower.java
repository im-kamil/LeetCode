class Solution {
    public long mostPoints(int[][] questions) {
         return getPoints(questions, 0, new long[questions.length]);
    }
    private long getPoints(int[][] q, int idx, long[] ans) {
        if (idx >= q.length) { // base cases.
            return 0;
        }else if (ans[idx] == 0) { // general case.
            int points = q[idx][0], brain = q[idx][1];
            // max points if we solve questions[i].
            long cur = points + getPoints(q, idx + 1 + brain, ans);
            // max points we can get for questions[i] 
            // (i = idx, idx + 1, ..., questions.length - 1).
            ans[idx] = Math.max(cur, getPoints(q, idx + 1, ans));
        }
        return ans[idx];
    }
}