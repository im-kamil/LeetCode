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
    public ListNode partition(ListNode head, int x) {
         ListNode smallerhead=new ListNode();
    ListNode smaller=smallerhead; 
    ListNode biggerhead=new ListNode();
    ListNode bigger=biggerhead;
    while(head!=null){
        if(head.val<x){
            smaller.next=head;
            smaller=smaller.next;
        }
        else{
            bigger.next=head;
            bigger=bigger.next;
        }
            
        head=head.next;
    }
    bigger.next=null;
    smaller.next=biggerhead.next;
    return smallerhead.next;
    }
}