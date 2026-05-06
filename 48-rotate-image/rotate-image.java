class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int[][] nums = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nums[i][j];
            }
        }
    }
}