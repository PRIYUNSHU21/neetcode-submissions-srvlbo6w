class Solution {
    public boolean isValidSudoku(char[][] board) {
    /*
        for a valid sudoku: nums 1-9 must not repeat in same rows cols and grid squares within the sudoku
        now as per the logic here used:
          we are using a hash set. 
          we add non null elements to the set..
          if we try adding some element already in the set..it returns false
        so we check for 3 conditions for the row, for the coloumn, and the squares...
        any one being false invalidates the sudoku
    */    
        HashSet<String> valid = new HashSet<>();

        for(int row = 0; row < 9; row++)
        {
            for(int col = 0; col<9; col++)
            {
                if(board[row][col] == '.')
                {
                    continue;
                }
                String i = Integer.toString(row/3);
                String j = Integer.toString(col/3);

                if(!valid.add(row + "in row" + board[row][col])
                ||!valid.add(col + "in col" + board[row][col]) || 
                !valid.add( i + '-' + j + board[row][col]))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
