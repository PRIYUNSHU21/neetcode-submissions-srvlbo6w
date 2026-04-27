class Solution {

    /*  lets explain the sliding window concept first with two pointing elements i,j
        i and j starts at index zero;
        we maintain a space where we keep elements that we have seen so far;
        in condition:
                        have we seen i th element in space?
                            if yes then:
                                we remove the j th index element from space and increment j (shrinking window)
                            else:
                                we add i th element to space
                                calculate max length of substring
                                increment i;
    */
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
