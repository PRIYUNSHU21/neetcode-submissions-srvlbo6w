
class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        if(edges.length == 0) return new int[0];

        List<Integer> parent = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            parent.add(i);
        }

        int a1 = 0;
        int b1 = 0;

        for(int[] edge : edges)
        {
            int root1 = find(edge[0], parent);
            int root2 = find(edge[1], parent);
            
            if(root1 != root2)
            {
                union(root1, root2, parent);
            }
            else
            {
                a1 = edge[0];
                b1 = edge[1];
            }
        }

        if(a1 == 0 && b1 == 0) return new int[0];

        return new int[]{a1,b1};
    }
    
    public int find(int edge, List<Integer> parent)
    {
        if(parent.get(edge) == edge) return edge;

        int root = find(parent.get(edge), parent);
        parent.set(edge, root); 
        return root;
    }
    
    public void union(int root1, int root2, List<Integer> parent)
    {
        parent.set(root2, root1); 
    }
}
