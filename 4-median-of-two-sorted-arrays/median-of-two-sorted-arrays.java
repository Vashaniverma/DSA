class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] temp=new int[nums1.length+nums2.length];

        for(int i=0;i<nums1.length;i++){
            temp[i]=nums1[i];
        }

        int count=0;
        for(int i=nums1.length;i<nums1.length+nums2.length;i++){
            temp[i]=nums2[count];
            count+=1;
        }
        Arrays.sort(temp);

        if(temp.length%2==0){
            int med1=(temp.length/2);
            int med2=med1-1;

            float median=(float)(temp[med1]+temp[med2])/2;
            return median;
        }
        else{
            int med1=(temp.length/2);

            float median=temp[med1];
            return median;
        }
    }
}