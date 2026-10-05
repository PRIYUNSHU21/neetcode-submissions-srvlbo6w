class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        if(grid.length == 0)return 0;

        int max = 0;

        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length; c++)
            {
                if(grid[r][c] == 1)
                {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }

        return max;
        
    }

    public int dfs(int[][]grid, int row, int col)
    {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)return 0;

        grid[row][col] = 0;

        int up = dfs(grid, row-1, col);
        int down = dfs(grid, row+1, col);
        int left = dfs(grid, row, col-1);
        int right = dfs(grid, row, col+1);

        return 1 + up + down + left + right;
    }
}
