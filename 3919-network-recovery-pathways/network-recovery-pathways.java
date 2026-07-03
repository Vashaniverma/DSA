import java.util.*;

public class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int maxCost = 0;
        for (int[] e : edges) maxCost = Math.max(maxCost, e[2]);

        int left = 0, right = maxCost, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canReach(edges, online, n, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canReach(int[][] edges, boolean[] online, int n, long k, int minEdge) {
        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build filtered graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], cost = e[2];
            if (!online[u] || !online[v] || cost < minEdge) continue;
            graph[u].add(new int[]{v, cost});
            indegree[v]++;
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (!online[u]) continue;
            for (int[] e : graph[u]) {
                int v = e[0], cost = e[1];
                if (dist[u] != Long.MAX_VALUE && dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                }
                if (--indegree[v] == 0) q.offer(v);
            }
        }
        return dist[n - 1] <= k;
    }
}
