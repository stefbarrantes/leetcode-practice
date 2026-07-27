class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1, lastCol = matrix[0].length - 1; 
        
        while(top <= bottom){
            int mid = top + (bottom - top) / 2; 

            if(target >= matrix[mid][0] && target <= matrix[mid][lastCol]) {
                // found the correct row to look
                int l = 0, r = lastCol;
                while(l <= r) {
                    int m = l + (r - l) / 2;
                    if(target == matrix[mid][m]) {
                        return true;
                    } else if(target > matrix[mid][m]){
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                return false;
            } else if(target > matrix[mid][lastCol]) {
                top = mid + 1;
            } else {
                bottom = mid - 1; 
            }
        }
        return false;   
    } 
}
