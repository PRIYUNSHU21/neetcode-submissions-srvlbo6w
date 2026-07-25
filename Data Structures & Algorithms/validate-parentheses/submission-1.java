class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> brac = new HashMap<>();

        brac.put(')' , '(');
        brac.put('}' , '{');
        brac.put(']' , '[');

        Stack<Character> stack = new Stack<>();

        char[] temp = s.toCharArray();

        for(int i = 0; i < temp.length; i++)
        {
            if(brac.containsKey(temp[i]))
            {
               if (stack.isEmpty() || stack.pop() != brac.get(temp[i])) 
                {
                    return false;
                }
            }
            else
            {
                stack.push(temp[i]);
            }
        }

        return stack.empty();
        
    }
}
