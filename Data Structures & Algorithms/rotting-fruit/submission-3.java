class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0)return -1;

        int ro = grid.length;
        int co = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < ro; r++)
        {
            for(int c = 0; c < co; c++)
            {
                if(grid[r][c] == 2)
                {
                    queue.add(new int[]{0,r,c});
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        int minutes = 0;

        while(!queue.isEmpty())
        {
            int[] temp = queue.pollFirst();
            int row = temp[1];
            int col = temp[2];

            for(int[] direc : directions)
            {
                int nr = row + direc[0];
                int nc = col + direc[1];

                if(nr>=0 && nr < ro && nc>=0 && nc < co && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = 2;
                    queue.offerLast(new int[]{temp[0]+1,nr,nc});
                    minutes = temp[0] + 1;
                }
            }
        }

        for(int r = 0; r < ro; r++)
        {
            for(int c = 0; c < co; c++)
            {
                if(grid[r][c] == 1)
                {
                   return -1;
                }
            }
        }

        return minutes ;
        
    }
}
