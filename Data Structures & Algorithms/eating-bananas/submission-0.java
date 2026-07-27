class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for(int i = 0; i < piles.length; i++)
        {
            if(piles[i] > max)
            {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int hours = 0;
        int k = Integer.MAX_VALUE;

        while(left <= right)
        {
            int mid = left + (right - left)/2;
            int sum = 0;
            for(int i = 0; i < piles.length; i++)
            {
                sum += (piles[i] + mid - 1) / mid;
            }
            hours = sum;
            if(hours <= h )
            {
                right = mid - 1;
                k = Math.min(k, mid);
            }
            else
            {
                left = mid + 1;
            }
        }

        return k;
        
    }
}
