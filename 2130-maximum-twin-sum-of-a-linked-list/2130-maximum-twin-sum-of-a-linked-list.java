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
    public int pairSum(ListNode head) {
          if (head == null) { // if there is no Node in the LinkedList , return null
            return 0;
        }
        if (head.next == null) { // if there is only one node in the LinkedList return the value of that node
            return head.val;
        }

        ListNode prev = null; // Creating a Node prev
        ListNode curr = findMid(head); // Creating a Node curr which will carry the middle Node
        ListNode next; // Creating a Node next

        while (curr != null) { // reversing the second part of the Linked List

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev; // Creating a Node right and assigning prev, it will point to first node of
                               // second half
        ListNode left = head; // Creating a Node left and assigning head

        int max = Integer.MIN_VALUE; // creating a int variable max and storing minimum value defined in java

        while (right != null) { // while loop for checking the sum of each twinSum and storing the value in max

            max = Math.max(left.val + right.val, max);
            right = right.next;
            left = left.next;
        }

        return max;

    }

    public ListNode findMid(ListNode head) { // creating a function to Find Middle Node of the Linked List
        ListNode slow = head; // Creating a Node slow pointing to head
        ListNode fast = head; // Creating a Node fast pointing to head

        while (fast != null && fast.next != null) { // while loop till fast not equal nulls and next node of fast not
                                                    // equal null
            slow = slow.next; // slow will move one node to the right
            fast = fast.next.next; // fast will move two nodes to the right
        }
        return slow;
    }
}