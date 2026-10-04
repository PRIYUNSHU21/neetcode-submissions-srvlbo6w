class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0)return 0;

        int count = 0;
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                if(grid[row][col] == '1')
                {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][]grid, int row, int col)
    {
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 ||grid[row][col] == '0' )return;

        grid[row][col] = '0';

         dfs(grid, row + 1, col);
         dfs(grid, row - 1, col);
         dfs(grid, row, col + 1);
         dfs(grid, row, col - 1);
    }
}
