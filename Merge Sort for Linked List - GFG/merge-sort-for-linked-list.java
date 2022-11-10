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
		   
		      head = new Solution().mergeSort(head);
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
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null || head.next==null){
            return head;
        }
        Node m=mid(head);
        Node left=head;
        Node right=m.next;
        m.next=null;
        left=mergeSort(left);
        right=mergeSort(right);
        Node ans=merge(left,right);
        return ans;
    }
    static Node merge(Node l,Node r){
        if(l==null ){
            return r;
        } if(r==null){
            return l;
        }
        Node temp=new Node(-1);
        Node ans=temp;
        while(l!=null && r!=null){
            if(l.data<r.data){
                temp.next=l;
                temp=temp.next;
                l=l.next;
            }
            else{
                temp.next=r;
                temp=temp.next;
                r=r.next;
            }
        }
        if(l!=null){
            temp.next=l;
        }
        if(r!=null){
            temp.next=r;
        }
        return ans.next;
    }
    static Node mid(Node head){
        Node fast=head.next;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;

    }
}


