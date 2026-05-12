class Solution {
    public int hammingWeight(int n) {
        int count=0;
        int temp=n;
        while(temp>0){
            temp=temp/2;
            count++;
        }
        int output=0;
        for(int i=0;i<count;i++){
            int left = 1<< i;
            if((n &left)!=0){
                output++;
            }
        }
        return output;        
    }
}