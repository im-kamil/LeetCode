//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer>stack=new Stack<>();
        stack.push(Integer.MIN_VALUE);
        for (int i = 0; i < asteroids.length; i++) {
           boolean cross=false;
           while(stack.size()>0&&asteroids[i]<0&&(stack.peek()==Math.abs(asteroids[i])||stack.peek()
           <Math.abs(asteroids[i]))&&stack.peek()>=0){
               if(stack.peek()==Math.abs(asteroids[i])){cross=true;stack.pop();break;}else stack.pop();
           };
           if(asteroids[i]>=0){
            stack.push(asteroids[i]);
        }else if(stack.size()==0||((stack.size()>0&&stack.peek()<0)&&cross==false)){
            stack.push(asteroids[i]);
        }
        }
        int arr[]=new int[stack.size()-1];
        for (int i = arr.length-1; i>=0;i--) {
            arr[i]=stack.peek();
            stack.pop();
        }
        return arr;
    
    }
}
