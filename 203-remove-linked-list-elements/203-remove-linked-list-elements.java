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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode pre = null , curr = head;
        while(curr!=null){
            if(curr.val==val){
              if(pre==null) head=curr.next;
                else pre.next=curr.next;
            }else
                pre = curr;
            curr = curr.next;
        }
        return head;
    }
}