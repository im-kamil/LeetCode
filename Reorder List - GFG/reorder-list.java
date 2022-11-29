//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new Solution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends


/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node middleNode(Node head){

           Node f=head;

            Node s=head;

            while(f!=null&&f.next!=null){

                

                s=s.next;

                f=f.next.next;

}

            return s;

        }

    public Node reverseList(Node head){

        if(head==null){

            return head;

        }

        Node prev=null;

        Node present=head;

        Node next=present.next;

        while(present!=null){

            present.next=prev;

            prev=present;

            present=next;

            

            

        if(next!=null){

            next=next.next;

        }

    }

    return prev;

}


    Node reorderlist(Node head) {
        // Your code here
         if(head==null || head.next==null){

            return head;

        }

         Node mid=middleNode(head);

        Node hs=reverseList(mid);

     Node hf=head;

    

        

        while(hf!=null&&hs!=null){

           Node temp=hf.next;

            hf.next=hs;

           hf=temp;

            temp=hs.next;

            hs.next=hf;

            hs=temp;

        }

            if(hf!=null){

                hf.next=null;

            

            }

            return head;
    }
}
