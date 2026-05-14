class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;

        for(int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            sum = sum * 26 + (ch - 'A' + 1);
        }

        return sum;
    }
}