class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode c = l1;
        ListNode d = l2;
        int count = 0;

        // FIX 1: Change to OR (||) so we count the full length of the longer list
        while(c != null || d != null)
        {
            if (c != null) c = c.next;
            if (d != null) d = d.next;
            count++;
        }
        int carry = 0;
        ListNode result = new ListNode();
        ListNode get = result;

        while(count != 0)
        {
            ListNode temp = new ListNode();
            int v1 = 0;
            int v2 = 0;

            // FIX 2: Check if the node is null, not the primitive int val
            if(l1 != null)
            {
                v1 = l1.val;
            }

            // FIX 3: Check if the node is null, and fix typo 'value' to 'val'
            if(l2 != null)
            {
                v2 = l2.val;
            }

            int num = (v1 + v2 + carry) % 10;
            // FIX 4: Use regular integer division instead of Math.floor
            carry =  (v1 + v2 + carry) / 10;

            temp.val = num;

            // FIX 5: Build the list on get.next to avoid an empty head
            get.next = temp;
            get = get.next;
            
            // FIX 6: Only advance pointers if they aren't null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            count--;
        }

        // FIX 7: Add a final node if there is a leftover carry after the loop
        if (carry > 0) {
            get.next = new ListNode(carry);
        }

        // FIX 8: Return result.next to skip the initial dummy 0 node
        return result.next;
    }
}

