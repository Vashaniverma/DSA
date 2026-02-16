class Solution(object):
    def maxProduct(self, nums):
        current_max = nums[0]
        current_min = nums[0]
        max_product = nums[0]
        
        for i in range(1, len(nums)):
            temp = current_max
            
            current_max = max(nums[i],
                              nums[i] * current_max,
                              nums[i] * current_min)
            
            current_min = min(nums[i],
                              nums[i] * temp,
                              nums[i] * current_min)
            
            max_product = max(max_product, current_max)
        
        return max_product
