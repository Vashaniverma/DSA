class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int i=0;
        int j=0;
        while(i<row){
            if(target==matrix[i][j]){
                return true;
            }
            j++;
            if(j==col){
                j=0;
                i++;
            }
        }
        return false;
    }
}