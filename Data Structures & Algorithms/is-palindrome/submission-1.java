class Solution {
    public boolean isPalindrome(String s) {

        String str2 = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        
        String reverse = new StringBuilder(str2).reverse().toString();

        if(str2.equals(reverse))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
