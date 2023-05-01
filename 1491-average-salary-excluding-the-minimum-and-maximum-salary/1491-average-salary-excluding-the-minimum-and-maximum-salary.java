class Solution {
    public double average(int[] salary) {
         double sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = salary.length;
        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (sum - min - max) / (n - 2);
    }
}