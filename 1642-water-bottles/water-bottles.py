class Solution(object):
    def numWaterBottles(self, numBottles, numExchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        sum=numBottles
        while(numBottles>=numExchange):
            div=numBottles/numExchange
            sum=sum+div
            rem=numBottles%numExchange
            numBottles=div+rem
        return(sum)  