class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12){
            hour=0;
        }
        double a=Math.abs((minutes*5.5)-(hour*30));
        double b=360-a;
        if(a<b){
            return a;
        }
        return b;
    }
}