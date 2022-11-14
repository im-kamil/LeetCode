//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
           if(head==null || head.next==null)return head;

        

        Node zero=new Node(-1);

        Node pz=zero;

        

         Node one=new Node(-1);

        Node po=one;

        

         Node two=new Node(-1);

        Node pt=two;

        

        Node curr=head;

        

        while(curr!=null){

            if(curr.data==0){

                pz.next=curr;

                pz=pz.next;

            }

            else if(curr.data==1){

                 po.next=curr;

                po=po.next;

            }

            else{

                 pt.next=curr;

                pt=pt.next;

            }

            

            curr=curr.next;

        }

        

        po.next=two.next;

        pz.next=one.next;

        pt.next=null;

        

        return zero.next;

    
    }
}
//   Node temp = head;

//         ArrayList<Integer> list = new ArrayList<Integer>();

//         while(temp != null){

//             list.add(temp.data);

//             temp = temp.next;

//         }

//         Collections.sort(list);

//         temp = head;

//         int i = 0;

//         while(temp != null){

//             temp.data = list.get(i);

//             temp = temp.next;

//             i++;

//         }

//         return head;

