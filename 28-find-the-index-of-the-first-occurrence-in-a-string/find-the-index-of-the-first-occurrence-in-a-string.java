class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int count = 0;
            int index = i;

            while (count < needle.length() &&
                   haystack.charAt(index) == needle.charAt(count)) {
                index++;
                count++;
            }

            if (count == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}