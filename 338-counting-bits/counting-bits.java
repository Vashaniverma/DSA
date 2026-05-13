class Solution {
    public int[] countBits(int n) {
        int[] temp=new int[n+1];
        temp[0]=0;
        
        for(int i=1;i<=n;i++){
            int count=0;
            int num=n;
            int loop=0;
            while(num>0){
                loop++;
                num=num/2;
            }
            for(int j=0;j<loop;j++){
                if((i & (1<<j))!=0){
                    count++;
                }
            }
            temp[i]=count;
        }
        return temp;
    }
}