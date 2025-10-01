class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        list=[]
        for i in range(len(nums)-1):
            for j in range(i,len(nums)-1):
                if nums[i]+nums[j+1]==target:
                    list.append(i)
                    list.append(j+1)
                    return(list)
        
        