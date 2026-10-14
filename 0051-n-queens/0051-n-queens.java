class Solution {
    private boolean isSafe(char[][] board, int row, int col,int n){
        //horizontal safety check
        for(int j = 0;j<n;j++){
            if(board[row][j] == 'Q') return false;
        }
        //vertical safety check
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q') return false;
        }
        //top left diagonal
        for(int i =row, j = col; i>=0 && j>=0 ; i--,j--){
            if(board[i][j]=='Q') return false;
        }
        //top right diagonal
        for(int i =row, j = col; i>=0 && j<n ; i--,j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
    private void nQueens(char[][] board, int row, int n, List<List<String>> ans){
        if(row == n){
            List<String> solution = new ArrayList<>();
            for(int i=0;i<n;i++){
                solution.add(new String(board[i]));
            }
            ans.add(solution);
            return;
        }
        for(int j = 0;j<n;j++){
            if(isSafe(board,row,j,n)){
                //place the queen safely in each row
                board[row][j] = 'Q';
                //recursion call for each row
                nQueens(board,row+1,n,ans);
                //backtracking if that spot isnt a safe place , put a dot there
                board[row][j]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> ans = new ArrayList<>();
        nQueens(board,0,n,ans);
        return ans;
    }
}