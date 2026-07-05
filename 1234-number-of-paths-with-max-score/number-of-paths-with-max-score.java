class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] dp = new int[n][n];       // max score at (i,j)
        int[][] count = new int[n][n];    // number of paths to (i,j)
        int MOD = 1_000_000_007;

        // initialize
        dp[n-1][n-1] = 0; 
        count[n-1][n-1] = 1;

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'X') continue; // obstacle

                if (i == n-1 && j == n-1) continue; // skip 'E'

                int maxScore = -1;
                int ways = 0;

                // check from bottom, right, diagonal
                int[][] dirs = {{1,0},{0,1},{1,1}};
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni < n && nj < n && count[ni][nj] > 0) {
                        if (dp[ni][nj] > maxScore) {
                            maxScore = dp[ni][nj];
                            ways = count[ni][nj];
                        } else if (dp[ni][nj] == maxScore) {
                            ways = (ways + count[ni][nj]) % MOD;
                        }
                    }
                }

                if (ways > 0) {
                    dp[i][j] = maxScore + ((c == 'S' || c == 'E') ? 0 : c - '0');
                    count[i][j] = ways;
                }
            }
        }

        return new int[]{dp[0][0], count[0][0]};
    }
}
