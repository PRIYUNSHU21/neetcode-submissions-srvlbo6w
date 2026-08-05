class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // MINIMAL CHANGE: Must ensure nums1 is the smaller array to prevent crash
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int partition = (total + 1) / 2;

        int left = 0;
        int right = nums1.length;

        int l1 = -1, l2 = -1, r1 = -1, r2 = -1;

        while(left <= right)
        {
            // MINIMAL CHANGE: Removed the "+ 1" offset to align with proper mid-point calculation
            int part1 = left + (right - left) / 2;
            int part2 = partition - part1;

            // MINIMAL CHANGE: Wrapped boundaries with ternary operators to stop ArrayIndexOutOfBoundsException
            l1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            l2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            
            r1 = (part1 == nums1.length) ? Integer.MAX_VALUE : nums1[part1];
            r2 = (part2 == nums2.length) ? Integer.MAX_VALUE : nums2[part2];

            if(l1 <= r2 && l2 <= r1)
            {
                // MINIMAL CHANGE: Check 'total' instead of 'partition' size for parity
                if(total % 2 == 0)
                {   
                    double l = Math.max(l1, l2);
                    double r = Math.min(r1, r2);
                    return (l + r) / 2.0; // Use 2.0 to avoid integer truncation
                }
                else
                {
                    return Math.max(l1, l2);
                }
            }

            // MINIMAL CHANGE: Added the missing binary search direction handler
            if (l1 > r2) {
                right = part1 - 1; // Look left
            } else {
                left = part1 + 1;  // Look right
            }
        }
        
        return 0.0;
    }
}
