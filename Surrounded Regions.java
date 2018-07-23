class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows == 0)
            return;
        
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O')
                check(board, i, 0);
            if(cols > 1) {
                if(board[i][cols - 1] == 'O')
                    check(board, i, cols - 1);
            }
                
        }
        for(int j = 1; j < cols - 1; j++) {
            if(board[0][j] == 'O')
                check(board, 0, j);
            if(rows > 1) {
                if(board[rows - 1][j] == 'O')
                    check(board, rows - 1, j);
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    public void check(char[][] board, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return;
        
        if(board[row][col] == 'O') {
            board[row][col] = '*';
            
            check(board, row + 1, col);
            check(board, row - 1, col);
            check(board, row, col + 1);
            check(board, row, col - 1);
        }
    }
}
