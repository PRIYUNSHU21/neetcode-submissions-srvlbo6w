class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            -> target is to get the k most frequent elements
            -> first we make a hashmap and count the occurances of the array elements
            -> this will take o(n) time
            -> then we would have to extract the top k high frequency entries from that map 
            -> bucket sort: we create an array of lists with the indices corresponding to the occurances
            -> at any specific index the the elements with matching frequency wwill be stored in lists
            -> then we would get the k highest incides from the array o(nlogn)
        */
        Map <Integer, Integer> frequent = new HashMap<>();

        for(int num : nums)
        {
           frequent.put(num, frequent.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int alpha : frequent.keySet())//keyset returns a set of keys in the dictionary
        {
            int freq = frequent.get(alpha);
            if(bucket[freq] == null)
             { bucket[freq] = new ArrayList<>();}
            bucket[freq].add(alpha);
        }

        int [] result = new int[k];
        int count =  0;
        for(int i = bucket.length -1; i>0 && count<k; i--)
        {
            if(bucket[i] != null)
            {
                for(int j : bucket[i])
                {
                    if(count < k)
                    {
                     result[count++] = j;
                    }
                }
            }
        }

        return result;
    }
}
