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

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
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
// you have to complete this function
class GfG
{
    public static Node partition(Node node){
        Node t = node.next;
        Node pivot = node;
        Node start = node;
        
        while(t!=null){
            if(t.data<pivot.data){
                start = start.next;
                int tmp = t.data;
                t.data = start.data;
                start.data = tmp;
            }
            t=t.next;
        }
        int tmp = start.data;
        start.data = pivot.data;
        pivot.data = tmp;
        
        return start;
    }
    public static Node quickSort(Node node)
    {
        if(node==null || node.next==null) return node;
        
        Node part = partition(node);
        Node tmp = part.next;
        part.next = null;
        quickSort(node);
        quickSort(tmp);
        part.next = tmp;
        return node;
    }
    
}
