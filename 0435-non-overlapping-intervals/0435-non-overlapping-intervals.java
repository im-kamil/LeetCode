class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         // Checking for invalid input:
        if(intervals.length == 0 || intervals == null)
            return 0;
        
        // Sort by the second number in each interval:
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0;
        // The second value of the last valid interval.
        int prevEnd = intervals[0][1]; 
        
        // We need to traverse the sorted intervals, counting the number of invalid intervals, and
        // updating the prevEnd value when you find a valid interval.
        for(int i = 1;  i < intervals.length; i++){
            // We have an invalid interval if the  current start time is < prevEnd;
            if(intervals[i][0] < prevEnd)
                removed++;
            else{
                prevEnd = intervals[i][1];
            }
        }
        
        // Return the number of intervals removed:
        return removed;
    }
}