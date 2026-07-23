class Solution {
    public String minWindow(String s, String t) {
        
        int left = 0;
        int matched = 0;
        int required = 0;

        int[] store = new int[128];
        int[] see = new int[128];

        int min_index = 0;
        int min_count = Integer.MAX_VALUE;

        // 1. Calculate required unique characters matching target frequencies
        for(int i = 0; i < t.length(); i++) {
            int load = t.charAt(i);
            if (store[load] == 0) {
                required += 1; // Count unique characters needed
            }
            store[load] += 1;
        }

        // 2. Use 'i' as the actual right-pointer loop index
        for(int i = 0; i < s.length(); i++) {   
            int rightChar = s.charAt(i);
            see[rightChar] += 1;

            // Increment matched only when character count matches target frequency
            if(store[rightChar] > 0 && see[rightChar] == store[rightChar]) {
                matched += 1;
            }

            while(matched == required) {
                // 3. Only update tracking values if a smaller window is found
                if (i - left + 1 < min_count) {
                    min_count = i - left + 1;
                    min_index = left;
                }

                int leftChar = s.charAt(left);
                
                // If dropping this char breaks our target match condition
                if(store[leftChar] > 0 && see[leftChar] == store[leftChar]) {
                    matched--;
                }
                see[leftChar] -= 1;
                left++;
            }
        }

        // 4. Added safe fallback return statement to pass compilation
        if(min_count != Integer.MAX_VALUE) {
            return s.substring(min_index, min_index + min_count);
        }
        
        return "";
    }
}

