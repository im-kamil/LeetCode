//{ Driver Code Starts
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

class MultiplyTwoLL{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Node head=null;
			Node phead=null;
			int n=sc.nextInt();
			while(n-->0){
				int n1=sc.nextInt();
				if(head==null)
				head=new Node(n1);
			else{
				addHead(head,n1);
			}
			}
			int m=sc.nextInt();
			while(m-->0){
				int n1=sc.nextInt();
				if(phead==null)
				phead=new Node(n1);
			else{
				addPhead(phead,n1);
			}
			}
		GfG g=new GfG();

System.out.println(g.multiplyTwoLists(head,phead));
		}
	}
    public static void addHead(Node node,int a) {
          if (node == null)
            return;
		if(node.next==null)
			node.next=new Node(a);
		else
			addHead(node.next,a);
	}
	public static void addPhead(Node node,int a){
		 if (node == null)
            return;
		if(node.next==null)
		node.next=new Node(a);
	else
		addPhead(node.next,a);
	}
	}
	
	
// } Driver Code Ends


/*Node is defined as
class Node
{
    int data; 
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class GfG{
  /*You are required to complete this method */
   public long multiplyTwoLists(Node l1,Node l2){
          //add code here.
          Node h1 = l1;

          Node h2 = l2;

          long sum1=0;

          long sum2=0;

          long mod = 1000000007;

          while(h1!=null||h2!=null)

          {

              if(h1!=null)

              {

                  sum1 = (sum1*10+(h1.data))%mod;

                  h1=h1.next;

              }

              if(h2!=null)

              {

                  sum2 = (sum2*10+(h2.data))%mod;

                  h2 = h2.next;

              }

          }

          return ((sum1*sum2)%mod);
   }
}