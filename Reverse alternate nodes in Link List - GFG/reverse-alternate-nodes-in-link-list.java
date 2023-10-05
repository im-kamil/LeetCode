//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node head)
    {
        // add your code here
         Node d1=new Node(-1);
        Node d2=new Node(-1);
        Node c=head;
        Node t1=d1;
        Node t2=d2;
        int p=1;
        while(c!=null)
        {
            if(p%2==1)
            {
                t1.next=c;
                t1=c;
            }
            else
            {
                t2.next=c;
                t2=c;
            }
            c=c.next;
            p++;
        }
        t1.next=null;
        t2.next=null;
        d2.next=rev(d2.next);
        t1.next=d2.next;
        head=d1.next;
    }
    public static Node rev(Node n)
    {
        Node prev=null;
        Node c=n;
        while(c!=null)
        {
            Node r=c.next;
            c.next=prev;
            prev=c;
            c=r;
        }
        return prev;
    }
}
