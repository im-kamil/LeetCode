/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode firstCurrNode = headA;
		while (firstCurrNode != null) {
			ListNode secondCurrNode = headB;
			while (secondCurrNode != null) {
				if (firstCurrNode == secondCurrNode) {
					return firstCurrNode;
				}
				secondCurrNode = secondCurrNode.next;
			}
			firstCurrNode = firstCurrNode.next;
		}
		return null;
        
    }
}