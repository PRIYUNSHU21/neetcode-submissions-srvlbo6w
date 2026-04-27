class Solution {
    public int lengthOfLongestSubstring(String s) {

       HashSet <Character> seen = new HashSet<>();

       char[] container = s.toCharArray();
       int result = 0;

       int i = 0;
       int j = 0;

      while(i < container.length)
      {
            if(seen.contains(container[i]))
            {
                seen.remove(container[j]);
                j++;
            }
            else
            {
                seen.add(container[i]);
                result = Math.max(result, i-j+1);
                i++;
            }
      }

      return result;
    }
}
