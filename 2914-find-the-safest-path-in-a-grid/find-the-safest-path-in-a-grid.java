import java.util.*;

class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Step 1: Multi-source BFS to compute minDist[r][c]
        int[][] minDist = new int[n][n];
        for (int[] row : minDist) Arrays.fill(row, -1);
        
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    q.offer(new int[]{r, c});
                    minDist[r][c] = 0;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : DIRS) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && minDist[nr][nc] == -1) {
                    minDist[nr][nc] = minDist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        // Step 2: Dijkstra-like search with max-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        pq.offer(new int[]{minDist[0][0], 0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int safeness = cur[0], r = cur[1], c = cur[2];
            if (r == n-1 && c == n-1) return safeness;
            
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{Math.min(safeness, minDist[nr][nc]), nr, nc});
                }
            }
        }
        return -1; // should not happen
    }
}
