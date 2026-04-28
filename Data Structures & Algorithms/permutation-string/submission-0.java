class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] store = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            store[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = 0, count = 0;
        
        while(right < s2.length()) {
            int index1 = s2.charAt(right) - 'a';

            if(store[index1] > 0) {
                store[index1]--;
                count++;
                right++;
            } 
            else if(left < right) {
                // Shrink window to recover "store" values
                store[s2.charAt(left) - 'a']++;
                count--;
                left++;
            } 
            else {
                // Window is empty and char at right isn't in s1
                left++;
                right++;
            }

            if(count == s1.length()) return true;
        }
        return false;
    }
}
