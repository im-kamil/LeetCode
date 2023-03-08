//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();

        int j=0;

        Node prev=head,curr=head;

        while(curr!=null){

            int arr[]=new int[26];

            for(int i=0; i<s.length(); i++)arr[s.charAt(i)-'a']++;

            while(j<s.length() && curr!=null){

                if(--arr[curr.data-'a']>=0){

                    j++;

                    curr=curr.next;

                }else break;

            }if(j==s.length() && check(arr)){

                Node x=new Node('x');

                Node ptr=x;

                while(j>0){

                    x.next=new Node(prev.data);

                    prev=prev.next;

                    x=x.next;

                    j--;

                }

                ans.add(ptr.next);

            }else {

                prev=prev.next;

                j=0;

            }

            curr=prev;

        }return ans;

    }static boolean check(int arr[]){

        for(int i:arr)if(i!=0)return false;

        return true;
    }
}