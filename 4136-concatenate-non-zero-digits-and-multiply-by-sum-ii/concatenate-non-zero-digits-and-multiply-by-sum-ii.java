class Solution {
    /**
     * Answers each [l, r] query with x * digitSum(x) mod 1e9+7, where x is
     * the number formed by concatenating the non-zero digits of s[l..r].
     *
     * Three prefix arrays make every query O(1):
     *   digitSum[i]  - sum of all digits in s[0..i-1]
     *   nzCount[i]   - number of non-zero digits in s[0..i-1]
     *   concatVal[i] - value (mod 1e9+7) of the non-zero digits of
     *                  s[0..i-1] read as one number
     *
     * @param s the digit string
     * @param queries inclusive index pairs [l, r]
     * @return one answer per query, each taken modulo 1e9+7
     */
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1_000_000_007L;
        int n = s.length();

        long[] digitSum = new long[n + 1];
        int[] nzCount = new int[n + 1];
        long[] concatVal = new long[n + 1];

        // pow10[k] = 10^k mod 1e9+7, used to shift a prefix value left.
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = pow10[i - 1] * 10 % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            digitSum[i + 1] = digitSum[i] + d;
            if (d == 0) {
                // Zeros are dropped: neither the count nor the value changes.
                nzCount[i + 1] = nzCount[i];
                concatVal[i + 1] = concatVal[i];
            } else {
                nzCount[i + 1] = nzCount[i] + 1;
                concatVal[i + 1] = (concatVal[i] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            // Number of non-zero digits inside s[l..r].
            int k = nzCount[r + 1] - nzCount[l];
            // Remove the prefix s[0..l-1] contribution: it sits k digit
            // places to the left inside concatVal[r+1], so shift it and
            // subtract. Add MOD before the final % so the truncating
            // remainder cannot produce a negative value.
            long x = ((concatVal[r + 1] - concatVal[l] * pow10[k] % MOD) % MOD + MOD) % MOD;
            // Digit sum of x equals the digit sum of the whole substring,
            // because the dropped zeros contribute nothing to the sum.
            long total = digitSum[r + 1] - digitSum[l];
            ans[i] = (int) (x * total % MOD);
        }
        return ans;
    }
}