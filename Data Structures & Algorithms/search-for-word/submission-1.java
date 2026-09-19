class Solution {
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for(int r = 0; r < row; r++)
        {
            for(int c = 0; c < col; c++)
            {
                if(board[r][c] == word.charAt(0))
                {
                    if(backtrack(board, r, c, 0, word))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
        
    }

    public boolean backtrack(char[][] board, int r, int c, int index, String word)
    {
        if(index == word.length())
        {
            return true;
        }

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index))
        {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean find = (backtrack(board, r + 1, c, index + 1, word) || backtrack(board, r-1, c, index + 1, word) ||backtrack(board, r, c + 1, index + 1, word) || backtrack(board, r, c - 1, index + 1, word));

        board[r][c] = temp;

        return find;
        
        }
}
