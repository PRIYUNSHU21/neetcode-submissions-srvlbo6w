class Solution {
    private static Map<Character, String> map = Map.of(
        '0',"",
        '1',"",
        '2',"abc",
        '3',"def",
        '4',"ghi",
        '5',"jkl",
        '6',"mno",
        '7',"pqrs",
        '8',"tuv",
        '9',"wxyz"
    );
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty())
        {
            return result;
        }
        List<Character> temp = new ArrayList<>();

        backtarck(result, temp, digits, 0);

        return result;
    }

    public void backtarck(List<String> result, List<Character> temp, String digits, int index)
    {
        if(index == digits.length())
        {
            StringBuilder b = new StringBuilder();
            for(char c : temp)
            {
                b.append(c);
            }
            result.add(b.toString());
            return;
        }

        char current = digits.charAt(index);
        String letters = map.get(current);

        for(int c=0; c < letters.length(); c++)
        {
            temp.add(letters.charAt(c));
            backtarck(result, temp, digits, index + 1);
            temp.remove(temp.size() - 1);

        }
    }
}
