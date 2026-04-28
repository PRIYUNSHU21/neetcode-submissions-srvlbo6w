class Solution {
    /*
        approach to solve this problem:

        we are maintaining a frequency array of size 26
        26 cuz we have 26 letters and one index alloted to 1 letter
        ascii concept: A = 65....then B = 66 so index (B) = 66-65 = 1
        when we encounter a letter we increment  the frequency of that index by one

        we are maintaining a window  bounded by left and right
        right scans letter -> its frequency gets incremented
        in the current window [right - left + 1] which element has highest frequency..(max)

        if(window size - max <= k) we have valid window and we store that windowed substring size in result
        else we reduce the window from the left:
                increment left pointer by 1
                decrese the frequency of the exited letter by 1
    */
    public int characterReplacement(String s, int k) {

            int[] store = new int[26];
            int left = 0;
            
            int max = 0;
            int result = 0;
            for(int right = 0; right < s.length(); right++)
            {
                int index = s.charAt(right) - 'A'; //logic it minuses the ascii value of the character to get index
                store[index]++;

                max = Math.max(max, store[index]);

                if((right-left+1)-max <= k)
                {
                    result = Math.max(result, right-left+1);
                }
                else
                {
                    int index_left = s.charAt(left) - 'A';
                    store[index_left]--;
                    left++;
                }

            }

            return result;
        
    }
}
