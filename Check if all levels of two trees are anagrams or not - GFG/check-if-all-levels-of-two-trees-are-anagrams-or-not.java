//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        Queue<Node> qt1 = new LinkedList<>();

        Queue<Node> qt2 = new LinkedList<>();

        

        qt1.offer(node1);

        qt2.offer(node2);

        

        while(qt1.size()>0 && qt2.size()>0)

        {

            int leve1 = qt1.size();

            int leve2 = qt2.size();

        ArrayList<Integer> ans1 = new ArrayList<>();

        ArrayList<Integer> ans2 = new ArrayList<>();

            

            if(leve1!=leve2)

            return false;

            

            for(int i=0;i<leve1;i++)

            {

                if(qt1.peek().left!=null)

                qt1.offer(qt1.peek().left);

                

                if(qt2.peek().left!=null)

                qt2.offer(qt2.peek().left);

                

                if(qt1.peek().right!=null)

                qt1.offer(qt1.peek().right);

                

                if(qt2.peek().right!=null)

                qt2.offer(qt2.peek().right);

                 

                 ans1.add(qt1.poll().data);

                 ans2.add(qt2.poll().data);

            }

             

            Collections.sort(ans1);

            Collections.sort(ans2);

            for(int m=0;m<leve1;m++)

            {

                int x = ans1.get(m);

                int y = ans2.get(m);

                if(x!=y)

                return false;

            }

        }

        return true;
    }
}
        
