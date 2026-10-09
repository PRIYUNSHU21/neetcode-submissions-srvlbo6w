class Solution {
    public void solve(char[][] grid) {
        
        if(grid == null || grid[0].length == 0)return;

        int row = grid.length;
        int col = grid[0].length;

        HashSet<Integer> seen = new HashSet<>();

        for(int i = 0; i < row; i++)
        {
            if(grid[i][0] == 'O')dfs(grid,i,0,seen);
            if(grid[i][col-1] == 'O')dfs(grid,i,col-1,seen);
        }
        for(int i = 0; i < col; i++)
        {
            if(grid[0][i] == 'O')dfs(grid,0,i,seen);
            if(grid[row-1][i] == 'O')dfs(grid,row-1,i,seen);
        }
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                int probe = col*i + j + 1;
                if(grid[i][j] != 'X' && !seen.contains(probe))
                {
                    grid[i][j] = 'X';
                }
            }
        }
    }

        public void dfs(char[][]grid, int r, int c, HashSet<Integer> seen)
        {
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 'X')return;

            int probe = grid[0].length*r + c + 1;
            if(seen.contains(probe))return;
            seen.add(probe);

            dfs(grid,r+1,c,seen);
            dfs(grid,r-1,c,seen);
            dfs(grid,r, c+1,seen);
            dfs(grid,r, c-1,seen);

            return;

            
        }
}
