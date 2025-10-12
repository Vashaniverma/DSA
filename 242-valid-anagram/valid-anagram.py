class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s1=sorted(s)
        t1=sorted(t)
        s1_str=''.join(s1)
        t1_str=''.join(t1)
        if(s1_str==t1_str):
            return True
        return False