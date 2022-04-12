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
    public ListNode deleteMiddle(ListNode head) {
         if(head.next == null)
            return null;
        ListNode slow = head, fast = head, beforeMid = head;
        while(fast != null && fast.next != null) {
            beforeMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        beforeMid.next = slow.next;
        return head;
        // if(head.next!=null)
        //     return null;
        // ListNode turtle = head , hare = head, beforeMid = head;
        // while(hare!=null && hare.next!=null){
        //     beforeMid = turtle;
        //     turtle = turtle.next;
        //     hare = hare.next.next;
        // }
        // beforeMid.next = turtle.next;
        //  return head;
    }
}