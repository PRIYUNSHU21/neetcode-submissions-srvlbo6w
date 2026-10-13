class KthLargest {

    private int[] heap;
    private int max_size;
    private int size = 0;

    public KthLargest(int k, int[] nums) {
        heap = new int[k+1];
        max_size = k;
        
        for(int i = 0; i < nums.length; i++)
        {
            heaping(heap, nums[i]);
        }
    }

    public void heaping(int[] heap, int num)
    {
        int s = size;

        if(s >= max_size)
        {
            if(num > heap[0])
            {
                heap[0] = num;
                bubbleDown(heap);
            }
            return;
        }

        heap[s] = num;
        size++;
        while(s > 0)
        {
            int parent = (s-1)/2;
            if(heap[parent] >= heap[s])
            {
                int temp = heap[parent];
                heap[parent] = heap[s];
                heap[s] = temp;
                s = parent;
            }
            else break;
        }
    }

    public void bubbleDown(int[] heap)
    {
        int parent = 0;
        while(true)
        {
            int left = 2*parent + 1;
            int right = 2*parent + 2;
            
            if (left >= size) break;
            
            int candidate = left;
            if (right < size && heap[right] < heap[left])
            {
                candidate = right;
            }

            if(heap[candidate] < heap[parent])
            {
                int temp = heap[candidate];
                heap[candidate] = heap[parent];
                heap[parent] = temp;
                parent = candidate;
            }
            else
            {
                break;
            }
        }
    }
    
    public int add(int val) {
        heaping(heap, val);
        return heap[0];
    }
}
