class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> temp=new HashMap<>();
        
        int maxelement=nums[0];
        int maxcount=0;

        for(int num:nums){
            int currentcount=temp.getOrDefault(num,0)+1;
            temp.put(num, currentcount);

            if(currentcount>maxcount){
                maxcount=currentcount;
                maxelement=num;
            }
        }
        return maxelement;
    }
}