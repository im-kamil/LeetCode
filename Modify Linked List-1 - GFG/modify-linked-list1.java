//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
      int ct=0;
        Node first=head,temp=head,t,t1;
        while(first!=null)
        {
            first=first.next;
            ct++;
        }
        int val=ct;
        if(ct%2==0)
        val-=1;
        first=head;
        temp=temp.next;
        first.next=null;
        for(int i=0;i<=val/2;i++)
        {
            t=temp.next;
            temp.next=first;
            first=temp;
            temp=t;
        }
        if(ct%2==0)
        t1=first.next;
        else
        t1=first.next.next;
        while(temp!=null)
        {
            first.data=first.data-t1.data;
            t1=t1.next;
            t=temp.next;
            temp.next=first;
            first=temp;
            temp=t;
        }
        
        first.data = first.data-t1.data;
        return first;
        
    }
}