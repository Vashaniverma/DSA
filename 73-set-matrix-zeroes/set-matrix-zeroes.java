class Solution {
    public void setZeroes(int[][] matrix) {
        int i = 0;
        int j = 0;
        int lenrow = matrix.length;
        int lencol = matrix[0].length;
        int[][] copy = new int[lenrow][lencol];

        while (i != lenrow) {
            copy[i][j] = matrix[i][j];
            j++;
            if (j == lencol) {
                j = 0;
                i++;
            }
        }
        i = 0;
        j = 0;

        while (i != lenrow) {
            if (matrix[i][j] == 0) {
                for (int k = 0; k < lencol; k++) {
                    copy[i][k] = 0;
                }
                for (int k = 0; k < lenrow; k++) {
                    copy[k][j] = 0;
                }
            }
            j++;
            if (j == lencol) {
                j = 0;
                i++;
            }
        }

        i = 0;
        j = 0;
        while (i != lenrow) {
            matrix[i][j] = copy[i][j];
            j++;
            if (j == lencol) {
                j = 0;
                i++;
            }
        }
    }
}