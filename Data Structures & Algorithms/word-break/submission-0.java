class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        if(n==0)return false;
        int[] hehe = new int[n];
        Arrays.fill(hehe, -1);

        int i =  hero(s, 0, wordDict, hehe);

        if(i == 1)return true;
        else return false;

    }

    public int hero(String s,int start, List<String> wordDict, int[] hehe)
    {
        if(start == s.length())return 1;

        if(hehe[start] != -1)return hehe[start];

        for(int end = start + 1; end <= s.length(); end++)
        {
            String temp = s.substring(start, end);

            if(wordDict.contains(temp))
            {
                hehe[start] =  hero(s, end, wordDict, hehe);
                if(hehe[start] == 1)return 1;
            }
        }

        hehe[start] = 0;
        return hehe[start];
    }
}
