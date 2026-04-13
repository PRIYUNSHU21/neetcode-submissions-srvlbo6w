class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        //loading the elements of string s on hash set
        for(int i=0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            //get or default fetches the previous occurance of the element in int count
            freq1.put(c, freq1.getOrDefault(c,0) + 1);
        }

         for(int i=0; i < t.length(); i++)
        {
            char d = t.charAt(i);
            //get or default fetches the previous occurance of the element in int count
            freq2.put(d, freq2.getOrDefault(d,0) + 1);
        }

       if( freq1.equals(freq2))
       {
            return true;
       }
       else
       {
            return false;
       }
    }
}
