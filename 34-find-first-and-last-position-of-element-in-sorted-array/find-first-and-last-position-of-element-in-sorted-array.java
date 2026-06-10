class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] temp=new int[2];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                temp[count]=i;
                count++;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
             if(target==nums[i]){
                temp[count]=i;
                break;
            }
        }
        if(count==0){
            temp[0]=-1;
            temp[1]=-1;
        }
        return temp;
    }
}