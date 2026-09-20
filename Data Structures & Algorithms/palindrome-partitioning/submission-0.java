class Solution {
    public List<List<String>> partition(String s) {

        if(s == null)
        {
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(result, temp, 0, s);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> temp, int start, String s)
    {
        if(start == s.length())
        {
            result.add(new ArrayList<>(temp));
        }

        for(int end = start; end < s.length(); end++ )
        {
            if(palindrome(s, start, end))
            {
                temp.add(s.substring(start, end + 1));
                backtrack(result, temp, end + 1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean palindrome(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
