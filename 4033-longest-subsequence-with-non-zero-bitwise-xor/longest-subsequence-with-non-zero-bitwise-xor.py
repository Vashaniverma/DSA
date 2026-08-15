import functools
class Solution:
    def longestSubsequence(self, nums: list[int]) -> int:
        n = len(nums)
        
        # Handle edge case where array contains only zeros
        if all(x == 0 for x in nums):
            return 0
        
        # Calculate the bitwise XOR sum of all elements
        total_xor = functools.reduce(lambda x, y: x ^ y, nums, 0)
        
        # If the total XOR sum is non-zero, the entire array is the longest subsequence
        if total_xor != 0:
            return n
        # If the total XOR sum is zero, we must remove one element to get a non-zero sum
        else:
            return n - 1



