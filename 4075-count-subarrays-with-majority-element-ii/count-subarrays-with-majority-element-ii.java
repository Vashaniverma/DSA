class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        // Fenwick Tree size: 2*n + 5 (to handle offsets safely)
        int[] bit = new int[2 * n + 5];
        
        // Helper functions for Fenwick Tree
        java.util.function.IntConsumer update = (idx) -> {
            for (; idx < bit.length; idx += idx & -idx) {
                bit[idx] += 1;
            }
        };
        
        java.util.function.IntFunction<Integer> query = (idx) -> {
            int sum = 0;
            for (; idx > 0; idx -= idx & -idx) {
                sum += bit[idx];
            }
            return sum;
        };
        
        int prefix = n + 2; // offset to avoid negatives
        update.accept(prefix);
        long ans = 0;
        
        for (int num : nums) {
            prefix += (num == target ? 1 : -1);
            ans += query.apply(prefix - 1);
            update.accept(prefix);
        }
        
        return ans;
    }
}
