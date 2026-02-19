class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        group=[]
        count=1
        for i in range (1,len(s)):
            if s[i]==s[i-1]:
                count+=1
            else:
                group.append(count)
                count=1
        group.append(count)
        ans=0
        for i in range(1,len(group)):
            ans+=min(group[i],group[i-1])
        return ans