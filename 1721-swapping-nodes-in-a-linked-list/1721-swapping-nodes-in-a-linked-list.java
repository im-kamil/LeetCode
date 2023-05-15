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
    public ListNode swapNodes(ListNode head, int k) {
       ListNode slow=head,fast=head,prev=null;
int i=0;
while(fast!=null&&i<k)
{
prev=fast;
fast=fast.next;
i++;
}
while(fast!=null)
{
slow=slow.next;
fast=fast.next;
}
if(prev!=null)
{
int x=prev.val;
prev.val=slow.val;
slow.val=x;
}
return head;
    }
}