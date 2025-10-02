class Solution(object):
    def maxBottlesDrunk(self, numBottles, numExchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        sum=numBottles
        sub=0
        while (numBottles>=numExchange):
            sub=sub+1
            numBottles=numBottles-numExchange
            numExchange=numExchange+1
            sum=sum+1
            if(numBottles<numExchange):
                numBottles=numBottles+sub
                sub=0
        return sum