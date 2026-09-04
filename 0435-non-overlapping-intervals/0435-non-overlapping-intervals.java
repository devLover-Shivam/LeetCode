class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // Number of intervals removed
        int count = 0;

        // End time of the last interval we kept
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Current interval overlaps with previous accepted interval
            if (intervals[i][0] < prevEnd) {
                count++;
            } 
            else {
                // No overlap, so keep current interval
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}