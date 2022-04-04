/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       // ListNode.next = node.next;
        // node.val = next.val;
        // node.val = next.next;
         node.val = node.next.val;
        node.next=node.next.next;
    }
}