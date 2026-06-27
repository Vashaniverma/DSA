import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;

        // Special case for 1
        if (freq.containsKey(1)) {
            int c1 = freq.get(1);
            maxLen = Math.max(maxLen, (c1 % 2 == 0) ? c1 - 1 : c1);
        }

        for (int num : freq.keySet()) {
            if (num == 1) continue; // already handled

            int length = 0;
            long curr = num;

            while (curr <= 1e9 && freq.getOrDefault((int) curr, 0) >= 2 
                   && freq.containsKey((int)(curr * curr))) {
                length += 2;
                curr = curr * curr;
            }

            // Peak element (only one occurrence needed)
            if (curr <= 1e9 && freq.getOrDefault((int) curr, 0) >= 1) {
                length += 1;
            }

            maxLen = Math.max(maxLen, length);
        }

        return maxLen;
    }
}
