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
    public int getDecimalValue(ListNode head) {
        int size = getSize(head);
        int power = size - 1;

    ListNode temp = head;
    int sum = 0;
    while(temp != null){
        sum += temp.val*(int)Math.pow(2,power);
        temp = temp.next;
        power --;
    }
    return sum;
}

 public static int getSize(ListNode head){
    int count = 0;
    ListNode temp = head;
    while(temp != null) {
        count ++;
        temp = temp.next;
    }
    return count;
    }
}