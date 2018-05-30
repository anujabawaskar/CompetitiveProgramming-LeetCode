class Solution {
    public boolean exist(char[][] board, String w) {
        char[] word = w.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean helper(int row, int col, char[][] board, char[] word, int index) {
        if(index == word.length)    //complete word is searched
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) //invalid index
            return false;
        if(board[row][col] != word[index])  //not a match
            return false;
        char temp = board[row][col];
        board[row][col] = '#';  //to not use the same character again
        boolean answer = helper(row + 1, col, board, word, index + 1) || helper(row - 1, col, board, word, index + 1)
                        || helper(row, col + 1, board, word, index + 1) || helper(row, col - 1, board, word, index + 1);
        
        board[row][col] = temp; //bring back the character for next iteration
        return answer;
    }
}
