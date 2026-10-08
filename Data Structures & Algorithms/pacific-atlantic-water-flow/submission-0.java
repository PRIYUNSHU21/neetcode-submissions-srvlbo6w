class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        if(heights == null || heights.length == 0)return null;

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for(int i = 0; i < heights.length; i++)//for row borders
        {         
            dfs(heights,i,0,pacific,heights[i][0]);
            dfs(heights,i,heights[0].length -1,atlantic, heights[i][heights[0].length-1]);
        }
        for(int i = 0; i < heights[0].length; i++)//for col borders
        {
            dfs(heights,0,i,pacific,heights[0][i]);
            dfs(heights,heights.length-1,i,atlantic, heights[heights.length-1][i]);

        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < heights.length; i++)
        {
            for(int j = 0; j < heights[0].length; j++)
            {
                if(pacific[i][j] == true && atlantic[i][j] == true)
                {
                    List<Integer> temp = List.of(i,j);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] checker, int compare)
    {
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || heights[r][c] < compare || checker[r][c] == true)return;

        checker[r][c] = true;

        dfs(heights,r+1,c,checker,heights[r][c]);
        dfs(heights,r-1,c,checker,heights[r][c]);
        dfs(heights,r,c+1,checker, heights[r][c]);
        dfs(heights,r,c-1,checker, heights[r][c]);

        return;
    }
}
