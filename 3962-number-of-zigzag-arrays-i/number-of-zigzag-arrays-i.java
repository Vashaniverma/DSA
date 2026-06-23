class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int range = r - l + 1;

        // dp arrays: inc[i][j] = arrays of length i ending at j with last step increasing
        //            dec[i][j] = arrays of length i ending at j with last step decreasing
        long[][] inc = new long[n + 1][range + 2];
        long[][] dec = new long[n + 1][range + 2];

        // Base case: arrays of length 1
        for (int j = 1; j <= range; j++) {
            inc[1][j] = 1;
            dec[1][j] = 1;
        }

        // DP transitions
        for (int i = 2; i <= n; i++) {
            long[] prefixInc = new long[range + 2];
            long[] prefixDec = new long[range + 2];

            // Build prefix sums
            for (int j = 1; j <= range; j++) {
                prefixInc[j] = (prefixInc[j - 1] + inc[i - 1][j]) % MOD;
                prefixDec[j] = (prefixDec[j - 1] + dec[i - 1][j]) % MOD;
            }

            for (int j = 1; j <= range; j++) {
                // If last step was increasing, next must be decreasing (choose k > j)
                dec[i][j] = (prefixInc[range] - prefixInc[j] + MOD) % MOD;
                // If last step was decreasing, next must be increasing (choose k < j)
                inc[i][j] = prefixDec[j - 1];
            }
        }

        // Sum all arrays of length n
        long result = 0;
        for (int j = 1; j <= range; j++) {
            result = (result + inc[n][j] + dec[n][j]) % MOD;
        }
        return (int) result;
    }
}
