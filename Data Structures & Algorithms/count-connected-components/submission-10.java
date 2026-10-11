class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] visited = new int[n];

        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];

            map.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            map.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }
        int component = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                component++;

                Deque<Integer> queue = new ArrayDeque<>();
                queue.offerLast(i);
                visited[i] = 1;

                while (!queue.isEmpty()) {
                    int node = queue.pollFirst();

                    if (map.get(node) == null)continue;

                    for (int child : map.get(node)) {
                        if (visited[child] != 0)continue;
                        visited[child] = 1;
                        queue.offerLast(child);
                    }
                }
            }
        }

         return component;
    }
}
