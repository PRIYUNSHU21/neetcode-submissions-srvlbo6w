class Solution {
    public boolean isPalindrome(String s) {

      int left = 0;
      int right = s.length()-1;

      while(left < right)
      {
            char lchar = s.charAt(left);
            char rchar = s.charAt(right);

            if(!Character.isLetterOrDigit(lchar))
            {
                left++;
            }
            else if(!Character.isLetterOrDigit(rchar))
            {
                right--;
            }
            else
            { 
                if(Character.toLowerCase(lchar) != Character.toLowerCase(rchar))
                {
                     return false;
                }
                 left++;
                 right--;
            }
      }

      return true;
    }
}
