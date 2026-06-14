import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
            
            if (seen.contains(n)) {
                return false; // cycle detected
            }
            seen.add(n);
        }
        
        return true;
    }
}
