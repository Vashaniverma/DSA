import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);       // Step 1: Sort the array
        arr[0] = 1;             // Step 2: First element must be 1
        int ans = 1;

        for (int i = 1; i < arr.length; ++i) {
            // Ensure arr[i] is at most arr[i-1] + 1
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}
