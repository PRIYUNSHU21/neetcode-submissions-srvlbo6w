/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode counter = head;
        int count = 0;

        while(counter != null)
        {
            counter = counter.next;
            count++;
        }

        if(count == n)
        {
            return head.next;
        }
        else if(head == null || count - n < 0)
        {
            return null;
        }

        ListNode tra = head;
        int tracker = 0;
        while(tracker != count - n - 1)
        {
            tra = tra.next;
            tracker++;
        } 
        
        if(tra.next.next == null)
        {
            tra.next = null;
        }
        else
        {
            tra.next = tra.next.next;
        }

        return head;


    }
}
