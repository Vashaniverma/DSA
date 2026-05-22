class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map=new HashMap<>();
        int[] temp= new int[2];
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(map.containsKey(need)){
                temp[0]=map.get(need);
                temp[1]=i;
                return temp;
            }
            map.put(nums[i],i);
        }
        return temp;
    }
}