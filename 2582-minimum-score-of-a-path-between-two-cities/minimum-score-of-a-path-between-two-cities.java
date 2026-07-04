class Solution {
    public int minScore(int n, int[][] roads) {
        // Union-Find setup
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        // Union all connected cities
        for (int[] road : roads) {
            union(parent, road[0], road[1]);
        }

        // Find the root of city 1 (connected component)
        int root = find(parent, 1);
        int minScore = Integer.MAX_VALUE;

        // Check all roads that belong to the same component
        for (int[] road : roads) {
            if (find(parent, road[0]) == root) {
                minScore = Math.min(minScore, road[2]);
            }
        }

        return minScore;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}
