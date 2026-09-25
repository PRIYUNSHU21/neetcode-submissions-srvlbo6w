class Solution {
    public List<List<String>> solveNQueens(int n) {

        if(n==0)return null;

        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();

        for(int r = 0; r < n; r++)
        {
            Arrays.fill(board[r], '.');
        }
        backtrack(board,result,n,0);

        return result;   
    }

    private HashSet<Integer> c = new HashSet<>();
    private HashSet<Integer> diag1 = new HashSet<>();
    private HashSet<Integer> diag2 = new HashSet<>();

    public void backtrack(char[][] board, List<List<String>> result, int n, int row)
    {
        if(row == n)
        {
            helper(board, result, n);
            return;
        }

        for(int col = 0; col < n; col++)
        {
            int d1 = row - col;
            int d2 = row + col;
            if(c.contains(col) || diag1.contains(d1) || diag2.contains(d2)) continue;
            c.add(col);
            diag1.add(d1);
            diag2.add(d2);

            board[row][col] = 'Q';

            backtrack(board, result, n, row+1);

            board[row][col] = '.';
            c.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }


    }

    public void helper(char[][] board, List<List<String>> result, int n)
    {
        List<String> res = new ArrayList<>();
        for(int row = 0; row < n; row++)
        {
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col < n; col++)
            {
                char c = board[row][col];
                sb.append(c);
            }
            res.add(sb.toString());
        }
        result.add(res);
    }
}
