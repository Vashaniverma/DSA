class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] output=new int[m+n];

        for(int i=0;i<m;i++){
            output[i]=nums1[i];
        }
        int count=m;
        for(int i=0;i<n;i++){
            output[count]=nums2[i];
            count++;
        }

        Arrays.sort(output);

        for (int i = 0; i < m + n; i++) {
            nums1[i] = output[i];
        }
    }
}