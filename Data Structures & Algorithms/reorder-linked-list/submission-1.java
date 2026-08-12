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
    public void reorderList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        //after the iteration the slow pointer will be at the middle of the list

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow;
        ListNode cur = slow.next;
        slow.next = null;

        while(cur != null)
        {
             ListNode nxt = cur.next;
             cur.next = prev;
             prev = cur;
             cur = nxt;
        }

        ListNode work = head;

        while(prev != slow && prev != null)
        {
           ListNode temp = work.next;
           ListNode temp2 = prev.next;

           work.next = prev;
           prev.next = temp;
           work = temp;
           prev = temp2;
        }
        
    }
}
