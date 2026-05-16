class Solution {
    public int missingNumber(int[] nums) {
        int[] temp=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            int count=1;
            int a = nums[i];
            temp[a]=count;
        }
        for(int i=0;i<nums.length;i++){
            if(temp[i]==0){
                return i;
            }
        }
        return nums.length;
    }
}