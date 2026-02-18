class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        number=bin(n)[2:]
        if len(number)==0 or len(number)==1:
            return True
        odd=number[::2]
        even=number[1::2]
        if(odd[0]!=even[0]):
            resultodd=len(set(odd))==1
            resulteven=len(set(even))==1
            return resultodd and resulteven
        return False
        