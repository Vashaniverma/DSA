class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26]; // frequency of each letter
        
        // Count frequency of each character
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // balloon → b a l l o o n
        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'] / 2; // need 2 'l'
        int o = freq['o' - 'a'] / 2; // need 2 'o'
        int n = freq['n' - 'a'];
        
        // Minimum of all counts gives the answer
        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}
