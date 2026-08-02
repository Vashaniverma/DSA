class Solution {
    /**
     * Finds the maximum product of two distinct digits in a number.
     * 
     * @param n The input number to extract digits from
     * @return The maximum product of two largest distinct digits
     */
    public int maxProduct(int n) {
        // Track the largest and second largest digits found
        int largestDigit = 0;
        int secondLargestDigit = 0;
      
        // Extract each digit from the number by repeatedly dividing by 10
        while (n > 0) {
            // Get the rightmost digit
            int currentDigit = n % 10;
          
            // Update the two largest digits based on current digit
            if (currentDigit > largestDigit) {
                // Current digit becomes the new largest
                // Previous largest becomes second largest
                secondLargestDigit = largestDigit;
                largestDigit = currentDigit;
            } else if (currentDigit > secondLargestDigit) {
                // Current digit is between largest and second largest
                secondLargestDigit = currentDigit;
            }
          
            // Remove the rightmost digit for next iteration
            n /= 10;
        }
      
        // Return the product of the two largest digits
        return largestDigit * secondLargestDigit;
    }
}