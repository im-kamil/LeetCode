/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // if(head==null){
        //     return false;
        // }
//         ListNode hare = head; // fast pointer 
//         ListNode turtle = head; // slow pointer 
        
//         while(hare!=null && hare.next==null){
//             hare = hare.next.next;
//             turtle = turtle.next;
            
//             if(hare == turtle){
//                 return true;
//             }
            
//         }
//         return false;
//     }
// }
  ListNode walker = head;
    ListNode runner = head;
    while (runner != null && runner.next != null) {
        walker = walker.next;
        runner = runner.next.next;
        if (walker == runner) {
            return true;
        }
    }
    return false;
}
}