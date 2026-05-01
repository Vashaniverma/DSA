class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int a=accounts.length;
        int b=accounts[0].length;
        int sum=0;
        
        for(int i=0;i<a;i++){
            int nums=0;
            for(int j=0;j<b;j++){
                nums+=accounts[i][j];
            }
            if(sum<nums){
                sum=nums;
            }
        }
        return sum;
    }
}