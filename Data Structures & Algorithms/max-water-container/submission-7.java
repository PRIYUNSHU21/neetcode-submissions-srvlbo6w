class Solution {
    public int maxArea(int[] heights) {

        int largest = 0;
        int i = 0;
        int j = heights.length-1;

        while( i < j )
        {
            int current_largest = Math.min(heights[i], heights[j])*(j-i);
            largest = Math.max(largest, current_largest);

            if(heights[i] < heights[j])
            {
                i ++;
            }
            else
            {
                j--;
            }
        }

        return largest;
        
    }
}
