class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1)return false;//a valid  tree has always n-1 number of edges where n is the number of nodes
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] visited = new int[n];
        int nodes = 0;

        for(int i = 0; i < edges.length; i++)
        {
            int n1 = edges[i][0];
            int n2 = edges[i][1];

            map.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            map.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offerLast(0);

        while(!queue.isEmpty())
        {
            int node = queue.pollFirst();

            visited[node]++;
            nodes++;

            if(map.get(node) == null)continue;//if nothing move to next iteration
            for(int child : map.get(node))
            {
                if(visited[child] > 0)continue;
                queue.offerLast(child);
            }
        }

        if(nodes == n)return true;

        return false;

    }
}
