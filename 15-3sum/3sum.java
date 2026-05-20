import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> temp = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {

                    temp.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    // skip duplicate j
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // skip duplicate k
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return temp;
    }
}