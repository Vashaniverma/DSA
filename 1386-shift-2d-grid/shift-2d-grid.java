class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length;
        int col = grid[0].length;

        int[] nums = new int[row * col];

        k = k % nums.length;

        int[] temp = new int[k];

        int i = 0;
        int j = 0;
        int count = 0;

        // Convert 2D grid to 1D array
        while(i < row){

            nums[count] = grid[i][j];

            count++;
            j++;

            if(j >= col){
                j = 0;
                i++;
            }
        }

        // Store last k elements
        int find = nums.length - k;

        int idx = 0;

        for(int l = find; l < nums.length; l++){

            temp[idx] = nums[l];
            idx++;
        }

        // Shift remaining elements
        for(int l = find - 1; l >= 0; l--){

            nums[l + k] = nums[l];
        }

        // Put last k elements at front
        for(int l = 0; l < temp.length; l++){

            nums[l] = temp[l];
        }

        // Convert back to List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();

        count = 0;

        for(i = 0; i < row; i++){

            List<Integer> tempList = new ArrayList<>();

            for(j = 0; j < col; j++){

                tempList.add(nums[count]);
                count++;
            }

            result.add(tempList);
        }

        return result;
    }
}