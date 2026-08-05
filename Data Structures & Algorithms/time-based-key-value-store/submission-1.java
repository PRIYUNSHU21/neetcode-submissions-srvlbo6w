class TimeMap {

    private static class Node
    {
        int timestamp;
        String value;

        Node(int timestamp, String value)
        {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private HashMap<String, List<Node>> store;

    public TimeMap() {

        store = new HashMap<>();       
    }
    
    public void set(String key, String value, int timestamp) {

        if(!store.containsKey(key))
        {
            store.put(key, new ArrayList<>());
        }

        Node adder = new Node(timestamp, value);

        store.get(key).add(adder);
        
    }
    
    public String get(String key, int timestamp) {

        if(!store.containsKey(key))
        {
            return "";
        }


        List<Node> box = store.get(key);

        int left = 0;
        int right = box.size() - 1;
        String result = "";

        while(left <= right)
        {
            int mid = left + (right - left)/2;

            if(box.get(mid).timestamp == timestamp)
            {
                return box.get(mid).value;
            }
            else if(box.get(mid).timestamp < timestamp)
            {
                result = box.get(mid).value;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return result;
        
    }
}
