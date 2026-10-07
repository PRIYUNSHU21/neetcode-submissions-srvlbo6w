class Solution {
    public void islandsAndTreasure(int[][] grid) {

        if(grid == null || grid.length == 0)return;

        Deque<int[]> queue = new ArrayDeque<>();

        int row = grid.length;
        int col = grid[0].length;

        for(int r = 0; r < row; r++ )
        {
            for(int c = 0; c < col; c++)
            {
                if(grid[r][c] == 0)
                {
                    queue.offerLast(new int[]{r,c});
                }
            }
        }

        int[][] coordinates = {{-1,0},{+1,0},{0,-1},{0,+1}};

        while(!queue.isEmpty())
        {
            int[] cur = queue.pollFirst();

            for(int[] cor : coordinates)
            {
                int r = cur[0] + cor[0];
                int c = cur[1] + cor[1];

                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 2147483647)
                {
                    grid[r][c] = 1 + grid[cur[0]][cur[1]];
                    queue.offerLast(new int[]{r,c});
                }
            }
        }
        
    }
}
