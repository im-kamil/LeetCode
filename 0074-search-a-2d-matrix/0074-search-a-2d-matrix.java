class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         // if (matrix == null || matrix.length == 0) {
         //        return false;
         //    }
         //    int start = 0, rows = matrix.length, cols = matrix[0].length;
         //    int end = rows * cols - 1;
         //    while (start <= end) {
         //        int mid = (start + end) / 2;
         //        if (matrix[mid / cols][mid % cols] == target) {
         //            return true;
         //        } 
         //        if (matrix[mid / cols][mid % cols] < target) {
         //            start = mid + 1;
         //        } else {
         //            end = mid - 1;
         //        }
         //    }
         //    return false;
        if(matrix.length==0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = (n*m)-1;
        while(lo<=hi){
           int mid = (lo+(hi-lo)/2);
            if(matrix[mid/m][mid%m]==target) return true;
            if(matrix[mid/m][mid%m]<target) lo = mid+1;
            else{
                hi = mid-1;
            }
        }
        return false;
    }
}