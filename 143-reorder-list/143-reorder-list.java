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
	ListNode reorderList(ListNode head) {
		ListNode currentNode = head;
		while (currentNode != null) {
			ListNode last = currentNode;
			while (last != null && last.next != null && last.next.next != null) {
				last = last.next;
			}
			if (currentNode == last) {
				break;
			}
			last.next.next = currentNode.next;
			currentNode.next = last.next;
			currentNode = currentNode.next.next;
			last.next = null;
		}
		return head;
	}
}