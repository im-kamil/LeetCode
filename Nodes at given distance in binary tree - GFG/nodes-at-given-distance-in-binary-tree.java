//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static void kdown(Node root, int d, Node blockNode, ArrayList<Integer> list) {
        if(root == null || d < 0 || root == blockNode) return;
        
        if(d == 0) {
           list.add(root.data);
           return;
        }
        
        kdown(root.left, d-1, blockNode, list);
        kdown(root.right, d-1, blockNode, list);
    }
    
    public static int helper(Node root, int target, int k, ArrayList<Integer> list) {
        if(root == null) return -1;
        
        if(root.data == target) {
            kdown(root, k-0, null, list);
            return 1;
        }
        
        int ld = helper(root.left, target, k, list);
        if(ld != -1) {
            kdown(root, k-ld, root.left, list);
            return ld+1;
        }
        int rd = helper(root.right, target, k, list);
        if(rd != -1) {
            kdown(root, k-rd, root.right, list);
            return rd+1;
        }
        
        return -1;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> list = new ArrayList<>();
        int num = helper(root, target, k , list);
       Collections.sort(list);
       return list;
    }
};