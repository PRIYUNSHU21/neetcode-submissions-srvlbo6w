class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses == 0)return null;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] temp : prerequisites)
        {
            int course = temp[0];
            int req = temp[1];

            indegree[course]++;

            map.computeIfAbsent(req, k->new ArrayList<>()).add(course);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int o = 0; o < numCourses; o++)
        {
            if(indegree[o] == 0)queue.offerLast(o);
        }

        int completed = 0;
        Set<Integer> result = new LinkedHashSet<>(); //preserves insertion order and also provides constant time retrievals

        while(!queue.isEmpty())
        {
            int c = queue.pollFirst();
            result.add(c);
            completed++;

            if(map.get(c) != null)
            {
                for(int ele : map.get(c))
                {
                    indegree[ele]--;
                    if(indegree[ele] == 0)queue.offerLast(ele);
                }
            }

        }
        int[] r = new int[numCourses];
        int j = 0;

        for(int i : result)
        {
            r[j++] = i;
        }

        if(numCourses == completed)return r;
        else return new int[0];
        
    }
}
