class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        set1=set(nums)
        l1=len(set1)
        l2=len(nums)
        if(l1==l2):
            return False
        return True
