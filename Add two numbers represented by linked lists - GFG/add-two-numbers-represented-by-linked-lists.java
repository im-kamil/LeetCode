//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
     static Node reverse(Node head){
        Node current = head, prev = null, next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    static int length(Node head){
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        if(length(first) < length(second)){
            Node temp = first;
            first = second;
            second = temp;
        }
        
        Node f = reverse(first);
        Node f1 = f;
        Node s = reverse(second);
        Node s1 = s;
        Node prev = null;
        int carry = 0;
        while(f1 != null || s1 != null){
            int fd = 0, sd = 0;
            if(f1 == null){
                fd = 0;
            }else{
                fd = f1.data;
            }
            
            if(s1 == null){
                sd = 0;
            }else{
                sd = s1.data;
            }
            int sum = fd + sd + carry;
            carry = sum/10;
            f1.data = sum%10;
            prev = f1;
            f1 = f1.next;
            if(s1 != null){
                s1 = s1.next;
            }
            
        }
        
        if(carry == 1){
            Node new_node = new Node(1);
            prev.next = new_node;
        }
        
        return reverse(f);
    }
}