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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null)
        {
            return list2;
        }
        else if(list2 == null)
        {
            return list1;
        }
        ListNode neww = new ListNode();
        ListNode newl = new ListNode();
        newl = neww;
        
        
        while(list1 != null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
               ListNode hi = new ListNode();
               hi.val = list1.val;
               newl.next = hi;
               newl = hi;
               list1 = list1.next;
            } 
            else
            {
               ListNode hi = new ListNode();
               hi.val = list2.val;
               newl.next = hi;
               newl = hi;
               list2 = list2.next;

            }
        }
        while(list1 != null)
        {
               ListNode hi = new ListNode();
               hi.val = list1.val;
               newl.next = hi;
               newl = hi;
               list1 = list1.next;
        }
        while(list2 != null)
        {
               ListNode hi = new ListNode();
               hi.val = list2.val;
               newl.next = hi;
               newl = hi;
               list2 = list2.next;
        }

        return neww.next;
    }
}