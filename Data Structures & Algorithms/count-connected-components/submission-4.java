class Solution {
    public int countComponents(int n, int[][] edges) {

        if(n == 0)return 0;
        if(n == 1)return 1;

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] visited = new int[n + 1];
        visited[n] = -1;
        int component = 0;

        for(int i = 0; i < edges.length; i++)
        {
            int n1 = edges[i][0];
            int n2 = edges[i][1];

            map.computeIfAbsent(n1, k->new ArrayList<>()).add(n2);
             map.computeIfAbsent(n2, k->new ArrayList<>()).add(n1);
            
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);

        while(!queue.isEmpty())
        {
            while(!queue.isEmpty())
            {
                int node = queue.pollFirst();
                visited[node]++;

                if(map.get(node) == null)continue;
                for(int child : map.get(node))
                {
                    if(visited[child] != 0)continue;
                    queue.offerLast(child);
                }
            }
            component++;
            for(int i = 0; i < n+1; i++)
            {
                if(visited[i] == -1)return component;
                if(visited[i] == 0){queue.offerLast(i);break;}
            }
        }

        return component;


    }
}
