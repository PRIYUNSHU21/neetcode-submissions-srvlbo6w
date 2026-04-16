class Solution {

/*
    what we have to do:
    > we will have a list of strings given to us
    > we will amalgamate the strings into one large string in the format {number#string}
    > The special character helps determine the end and  start of new strings while number is the number of characters
    > we will use string builder for the string amalgamation (it reserves a small pool of space thus making the string mutable)
*/
    public String encode(List<String> strs) {

        StringBuilder build = new StringBuilder();//playground for mutation and manipulation

        for(String unit : strs)
        {
            build.append(unit.length() + "#" + unit);
        }

        return build.toString(); //making the string immutable

    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        int i= 0;
       while(i<str.length())
       {
        int j = i;
        while(str.charAt(j) != '#')
        {
            j++;
        }
        int length = Integer.parseInt(str.substring(i,j));
        i = j+1;
        j = j + length;
        result.add(str.substring(i,j+1));
        i = j+1;
       }
       return result;
    }
}
