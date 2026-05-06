class Solution {
    public int[][] transpose(int[][] matrix) {
        int m=matrix[0].length;
        int n=matrix.length;
        int[][] nums=new int[m][n];
        int i=0;
        int j=0;

        while(i<matrix.length){
            nums[j][i]=matrix[i][j];
            j++;
            if(j==matrix[0].length){
                i=i+1;
                j=0;
            }
        }
        return nums;
    }

}