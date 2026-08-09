class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        /* for(int i =0;i<n;i++){
            if(matrix[i][0]<= target && target<=matrix[i][m-1]){
                return bS(matrix[i],target);
            }
        }

        return false; */

        // we're doing optimal flattened binary search where we can fatten the entire rows and columns to single array hypothetically.
        int low = 0;
        int high = (n*m)-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col]== target) return true;

            else if(matrix[row][col] < target) low = mid+1;

            else high = mid-1;
        }

        return false;
    }

    private boolean bS(int arr[],int x){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x) return true;
            if(arr[mid] > x) high = mid-1;
            else low= mid+1;
        }

        return false;
    }

}