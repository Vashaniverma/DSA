class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s="";
        int len=strs.length-1;
        int i=0;
        while(i<strs[0].length()){
            if(strs[0].charAt(i)!=strs[len].charAt(i)){
                return s;
            }
            else{
                s+=strs[0].charAt(i);
                i++;
            }
        }
        return s;
    }
}