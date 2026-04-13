class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
       /* thoughts
          -> extract each string from the list and convert them to char array (enumerates letters)
          -> we have a dictionary (key - value pairs)
          ->if for that sorted string a key exists then in value (a list) to that key,
               we put that original unsorted string
          -> if the key doesnot exist we make this sorted string as key and 
               make a list against this key with the first member being the unsorted string
        */
       Map <String, List<String>> anagrams = new HashMap<>();
       for(String original : strs)
       {
            char[] step = original.toCharArray();
            Arrays.sort(step);
            String sorted = new String(step); // converts the character array to a string via new string

            anagrams.computeIfAbsent(sorted, k -> new ArrayList<>()).add(original);
       }

       return new ArrayList<>(anagrams.values());
    }
}