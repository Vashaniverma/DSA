public class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // counts for 'a', 'b', 'c'
        int left = 0, result = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            // shrink window until it still contains all 3 chars
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += n - right; // all substrings from right to end are valid
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }
}
