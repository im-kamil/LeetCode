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
    public ListNode mergeKLists(ListNode[] lists) {
         if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE, lists[0]);
        ListNode curr = dummy;
        for (int i = 1; i < lists.length; i++) {
            curr = merge(curr, lists[i]);
        }
        return curr.next;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr.next = new ListNode(curr1.val);
                curr1 = curr1.next;
            } else {
                curr.next = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        while (curr1 != null) {
            curr.next = new ListNode(curr1.val);
            curr1 = curr1.next;
            curr = curr.next;
        }
        while (curr2 != null) {
            curr.next = new ListNode(curr2.val);
            curr2 = curr2.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}