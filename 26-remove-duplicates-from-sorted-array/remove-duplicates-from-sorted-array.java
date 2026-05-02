class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        ArrayList<Integer> temp = new ArrayList<>();

        temp.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] != temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            }
        }

        for(int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }

        return temp.size();
    }
}