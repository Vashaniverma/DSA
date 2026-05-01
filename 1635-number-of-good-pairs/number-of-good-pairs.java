class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int good=0;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(j>i){
                    if(nums[i]==nums[j]){
                    good+=1;
                    }
                }
            }
        }
        return good;
    }
}