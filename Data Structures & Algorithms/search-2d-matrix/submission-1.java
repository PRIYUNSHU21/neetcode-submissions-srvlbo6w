class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int length = matrix.length * matrix[0].length;

        int left = 0;
        int  right = length - 1;

        while(left <= right)
        {
            int mid = left + (right - left)/2;

            int row = Math.floorDiv(mid, matrix[0].length);
            int col = mid % matrix[0].length;

            if(target == matrix[row][col])
            {
                return true;
            }
            else if(target <= matrix[row][col])
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return false;
    }
}
