import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Step 1: Sort intervals
        // Sort by start ascending, and if equal, by end descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // Step 2: Traverse and count uncovered intervals
        int count = 0;
        int end = 0;

        for (int[] interval : intervals) {
            if (interval[1] > end) {
                count++;
                end = interval[1];
            }
            // If interval[1] <= end, it's covered
        }

        return count;
    }
}
