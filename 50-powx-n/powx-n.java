class Solution {
    public double myPow(double x, int n) {
        if(n>0 || n<0){
            double a=Math.pow(x,n);
            return a;
        }else{
            return 1;
        }
    }
}