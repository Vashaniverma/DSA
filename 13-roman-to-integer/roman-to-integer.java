class Solution {
    public int romanToInt(String s) {
        int sum=0;
        char[] rom={'I','V','X','L','C','D','M'};
        int[] num={1,5,10,50,100,500,1000};
        int prev=0;

        for(int i=s.length()-1;i>-1;i--){
            char str=s.charAt(i);

            int count=0;
            while(count<7){
                if(str==rom[count]){
                    if(prev>num[count]){
                        prev=num[count];
                        sum-=num[count];

                        break;
                    }
                    else{
                        sum+=num[count];
                        prev=num[count];
                        break;
                    }
                }
                count++;
            }
        }
        return sum;

    }
}