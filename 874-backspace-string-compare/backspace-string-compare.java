import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ch1 = new Stack<>();
        Stack<Character> ch2 = new Stack<>();

        // Process first string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!ch1.isEmpty()) ch1.pop();
            } else {
                ch1.push(s.charAt(i));
            }
        }

        // Process second string
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!ch2.isEmpty()) ch2.pop();
            } else {
                ch2.push(t.charAt(i));
            }
        }

        // Compare stacks
        return ch1.equals(ch2);
    }
}
