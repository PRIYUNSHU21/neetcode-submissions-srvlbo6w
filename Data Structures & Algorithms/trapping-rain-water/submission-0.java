class Solution {
    public int trap(int[] height) {
        
        int counter = 0;
        int lmax = height[0];
        int rmax = height[height.length - 1];
        int l = 0;
        int r = height.length -1;

        while(l<r)
        {
            if(lmax <= rmax)
            {
                if(lmax >= height[l])
                {
                    counter += lmax - height[l];
                    l++;
                    lmax = Math.max(lmax, height[l]);
                
                }
                else
                {
                    lmax = height[l];
                    l++;
                }
            }
            else
            {
                if(rmax >= height[r])
                {
                    counter += rmax - height[r];
                    r--;
                    rmax = Math.max(rmax, height[r]);
                
                }
                else
                {
                    rmax = height[r];
                    r++;
                }
            }
        }

        return counter;
    }
}
