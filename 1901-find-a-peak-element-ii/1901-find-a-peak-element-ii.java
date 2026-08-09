class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            // Find maximum element in column 'mid'
            int row = maxElm(mat,n,mid);

            int left = mid-1>=0 ? mat[row][mid-1] : -1;
            int right = mid+1<m ? mat[row][mid+1] : -1;

            // Current element is greater than both horizontal neighbours
            if(mat[row][mid] > left && mat[row][mid]>right){
                return new int[]{row, mid};
            }
            // Left neighbour is bigger -> move left
            else if(mat[row][mid] < left) high = mid-1;
            // Right neighbour is bigger -> move right
            else low = mid+1;
        }

        return new int[]{-1, -1};
    }

    private int maxElm(int[][] mat, int n, int col) {

        int maxRow = 0;

        for (int i = 1; i < n; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }

        return maxRow;
    }
}