class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] temp = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target==nums[i]+nums[j]){
                    temp[0]=i;
                    temp[1]=j;
                    return temp;
                }
            }
        }
        return temp;
    }
}