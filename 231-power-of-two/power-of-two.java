class Solution {
    public boolean isPowerOfTwo(int n) {
        int i=0;
        if(n <= 0){
            return false;
        }
        while((long)Math.pow(2,i)<=n){
            if((long)Math.pow(2,i)==n){
                return true;
            }
            i++;
        }
        return false;
    }
}