class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] temp=new int[arr.length];
        int[] nums=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int diff=Math.abs(x - arr[i]);
            temp[i]=diff;
            nums[i]=diff;
        }
        Arrays.sort(temp);
        List<Integer> a=new ArrayList<>();

       for(int i = 0; i < k; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(temp[i] == nums[j]) {
                    a.add(arr[j]);
                    nums[j]=-1;
                    break;
                }
            }
       }
        Collections.sort(a);
        return a;


        
    }
}