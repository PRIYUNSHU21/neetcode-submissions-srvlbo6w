class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
        {
            return null;
        }

        ListNode result = new ListNode();
        ListNode ptr = result;
        PriorityQueue<Integer> hehe = new PriorityQueue<>();

        for(int i = 0; i < lists.length; i++)
        {
            while(lists[i] != null)
            {
                hehe.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        while(!hehe.isEmpty())
        {
            ListNode temp = new ListNode();
            temp.val = hehe.poll();
            ptr.next = temp;
            ptr = ptr.next;
        }

        return result.next;
    }
}
