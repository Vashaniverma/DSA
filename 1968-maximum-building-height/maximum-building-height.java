import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        for (int[] r : restrictions) list.add(r);

        // Building 1 is always height 0
        list.add(new int[]{1, 0});
        // Building n can reach at most n-1
        list.add(new int[]{n, n - 1});

        // Sort restrictions by building index
        list.sort((a, b) -> a[0] - b[0]);

        // Forward pass: propagate restrictions left to right
        for (int i = 1; i < list.size(); i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], prev[1] + (curr[0] - prev[0]));
        }

        // Backward pass: propagate restrictions right to left
        for (int i = list.size() - 2; i >= 0; i--) {
            int[] next = list.get(i + 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], next[1] + (next[0] - curr[0]));
        }

        // Calculate maximum possible peak height
        int maxHeight = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            int dist = curr[0] - prev[0];
            // Peak achievable between prev and curr
            int peak = (prev[1] + curr[1] + dist) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }

        return maxHeight;
    }
}
