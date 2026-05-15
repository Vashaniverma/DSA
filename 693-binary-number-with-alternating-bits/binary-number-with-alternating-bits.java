class Solution {
    public boolean hasAlternatingBits(int n) {
        int m=n;
        int count=0;
        while(m>0){
            m=m/2;
            count++;
        }
        int nums;
        if((n&1)!=0){
            nums=1;
        }
        else{
            nums=0;
        }
        for(int i=1;i<count;i++){
            if(nums==1){
                if((n&(1<<i))!=0){
                    return false;
                }
                nums=0;
            }
            else{
                if((n&(1<<i))==0){
                    return false;
                }
                nums=1;
            }
        }
        return true;
    }
}