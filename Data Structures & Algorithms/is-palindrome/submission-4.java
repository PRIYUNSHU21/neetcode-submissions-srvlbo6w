class Solution {
    /*
        used the two pointer approach:

        left = start of the string
        right = end character of the string

       -> comparing the left char to the right char as we com to the middle until left<right
       ->to omit special characters and punctuations : Character.isLetterOrDigit(char) = true if char is digit or letter

    */
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
