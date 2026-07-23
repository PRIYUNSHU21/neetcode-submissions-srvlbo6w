class Solution {
    public String minWindow(String s, String t) {
        /*
            This solution uses a Two-Pointer Sliding Window approach to dynamically 
            find the smallest valid substring. The logic expands the window using 
            the right pointer to collect characters until the criteria are satisfied, 
            then shrinks it from the left using the left pointer to minimize the window size 
            while maintaining validity. The main mechanics are driven by the store and seen 
            frequency arrays which map required target frequencies against current window contents. 
            Meanwhile, the required and matched counters track unique character goal milestones, 
            and min_count coupled with min_index safely remembers the absolute shortest valid window dimensions found.
        */
        int left = 0;
        int[] store = new int[128];
        int[] seen = new int[128];

        int min_count = Integer.MAX_VALUE;
        int min_index = 0;

        int matched = 0;
        int required = 0;

        for(int i = 0; i < t.length(); i++)
        {
           int load = t.charAt(i);
           if(store[load] == 0)
           {
                required++;
           }
           store[load]++;
        }

        for(int right = 0; right < s.length(); right++)
        {
            int right_char = s.charAt(right);
            seen[right_char]++;

            if(seen[right_char] > 0  && seen[right_char] == store[right_char])
            {
                matched++;
            }
            while(matched == required)
            {   
                int left_char = s.charAt(left);
                if(right - left + 1 < min_count)
                {
                    min_count = right - left + 1;
                    min_index = left;
                }
                seen[left_char]--;
                if(seen[left_char] < store[left_char] && store[left_char] > 0)
                {
                    matched--;
                }
                left++;
            }            
        }

        if(min_count == Integer.MAX_VALUE)
        {
            return "";
        }
        else
        {
            return s.substring(min_index, min_index + min_count);
        }
        
    }
}
