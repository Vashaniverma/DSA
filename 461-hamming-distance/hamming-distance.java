class Solution {
    public int hammingDistance(int x, int y) {
        int j= x^y;
        int m=j;
        int loop=0;
        int count=0;
        while(m>0){
            loop++;
            m=m/2;
        }
        for(int i=0;i<loop;i++){
            if((j&(1<<i))!=0){
                count++;
            }
        }
        return count;
    }
}