class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
        {
            return null;
        }

        ListNode result = new ListNode();
        ListNode ptr = result;

        while(true)
        {   
            int index = -1; 
            int val = Integer.MAX_VALUE;
            
            // FIX: Access the first element using array index syntax [0]
            if (lists[0] != null) {
                val = lists[0].val;
                index = 0;
            }

            for(int j = 1; j < lists.length; j++)
            {   
                if(lists[j-1] != null && lists[j] != null)
                {
                    int t1 = Math.min(lists[j-1].val, lists[j].val);
                    if (t1 < val) {
                        val = t1;
                        index = (lists[j-1].val <= lists[j].val) ? (j - 1) : j;
                    }
                }
                else if(lists[j-1] == null && lists[j] != null)
                {
                    if (lists[j].val < val) {
                        val = lists[j].val;
                        index = j;
                    }
                }
                else if(lists[j-1] != null && lists[j] == null)
                {
                    if (lists[j-1].val < val) {
                        val = lists[j-1].val;
                        index = j - 1;
                    }
                }
            }

            if (index == -1 || lists[index] == null) {
                break;
            }

            ListNode temp = new ListNode(val);
            ptr.next = temp;
            ptr = ptr.next;
            lists[index] = lists[index].next;
        }
        return result.next; 
    }
}
