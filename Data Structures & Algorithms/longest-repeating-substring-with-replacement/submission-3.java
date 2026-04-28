class Solution {
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
