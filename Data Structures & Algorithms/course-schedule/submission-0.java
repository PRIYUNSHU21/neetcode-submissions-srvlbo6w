class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 0)return true;

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] ele : prerequisites)
        {
            int course = ele[0];
            int req = ele[1];

            indegree[course]++;
            map.computeIfAbsent(req, k->new ArrayList()).add(course);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)queue.offerLast(i);
        }

        int completed = 0;

        while(!queue.isEmpty())
        {
            int c = queue.pollFirst();
            completed++;
            if(map.get(c)!=null)
            {
                for(int temp : map.get(c))
                {
                    indegree[temp]--;
                    if(indegree[temp] == 0)queue.offerLast(temp);
                }
            }
        }

        if(completed == numCourses)return true;

        return false;
        
    }
}
