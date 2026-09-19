class Solution {
    public List<String> generateParenthesis(int n) {

        if(n == 0)
        {
            return null;
        }
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        backtrack(result, temp, n, 0, 0);

        return result;
    }

   public void backtrack(List<String> result, StringBuilder temp, int max, int open, int close)
   {
        if(temp.length() == 2 * max)
        {
            result.add(temp.toString());
            return;
        }

        if(open < max)
        {
            temp.append("(");
            backtrack(result,  temp, max, open+1, close);
            temp.deleteCharAt(temp.length() -1);
        }
        if(close < open)
        {
            temp.append(")");
            backtrack(result, temp, max, open, close+1);
            temp.deleteCharAt(temp.length() -1);
        }
   }
}
