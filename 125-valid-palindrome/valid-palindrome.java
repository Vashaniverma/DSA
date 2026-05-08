class Solution {
    public boolean isPalindrome(String s) {
        String result=s.replaceAll("[^a-zA-Z0-9]","");
        String lower=result.toLowerCase();
        int n=lower.length();
        for(int i=0;i<lower.length()/2;i++){
            if(lower.charAt(i)!=lower.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}