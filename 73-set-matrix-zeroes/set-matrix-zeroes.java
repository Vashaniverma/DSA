class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] nums=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                nums[i][j]=matrix[i][j];
            }
        }

        int m=0;
        int n=0;
        while(m<row){
            if(matrix[m][n]==0){
                for(int i=0;i<col;i++){
                    nums[m][i]=0;
                }
                for(int i=0;i<row;i++){
                    nums[i][n]=0;
                }
            }
            n++;
            if(n==col){
                n=0;
                m=m+1;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=nums[i][j];
            }
        }
    }
}