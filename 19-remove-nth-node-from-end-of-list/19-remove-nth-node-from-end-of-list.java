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
        
        // size is calculated of first step
        
   if(head.next == null) {
       return null;
   }
  
  
   int size = 0;
   ListNode curr = head;
   while(curr != null) {
       curr = curr.next;
       size++;
   }
  
   //removing SIZEth node from last i.e. head
   if(n == size) {
       return head.next;
   }
  
   //find previous node
   int indexToSearch = size - n; // position to find
   ListNode prev = head; // previous node
   int i = 1; // current position
  
   while(i < indexToSearch) {
       prev = prev.next;
       i++;
   }
  
   prev.next = prev.next.next;
        return head;
    }
}