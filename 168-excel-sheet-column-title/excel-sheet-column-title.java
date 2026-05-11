class Solution {
    public String convertToTitle(int columnNumber) {
        String ans="";
        while(columnNumber>0){
            columnNumber--;
            int rem=columnNumber%26;
            columnNumber/=26;
            ans = (char)('A' + rem) + ans;
    
        }
        return ans;
    }
}