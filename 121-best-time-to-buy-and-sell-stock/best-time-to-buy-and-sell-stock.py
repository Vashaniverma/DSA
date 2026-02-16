class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min_num=prices[0]
        max_num=0

        for i in range(1, len(prices)):
            if prices[i] < min_num:
                min_num=prices[i]
            
            profit=prices[i] - min_num

            if profit>max_num:
                max_num=profit

        return max_num

        
        