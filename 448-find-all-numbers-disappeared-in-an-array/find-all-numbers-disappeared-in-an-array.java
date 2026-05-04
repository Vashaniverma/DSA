import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int[] temp = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int j = nums[i];
            temp[j - 1]++;
        }

        List<Integer> output = new ArrayList<>();

        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == 0) {
                output.add(i + 1);
            }
        }

        return output;
    }
}