//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
         int left=0;

        int right=c-1;

        int top=0;

        int bottom=r-1;

        ArrayList<Integer> list=new ArrayList<Integer>();

        while( top<=bottom && left<=right)

        {

            for(int i=left;i<=right;i++)

            {

                list.add(matrix[top][i]);

            }

            top++;

            for(int i=top;i<=bottom;i++)

            {

                list.add(matrix[i][right]);

            }

            right--;

            if(top<=bottom)

            {

                for(int i=right;i>=left;i--)

                {

                    list.add(matrix[bottom][i]);

                }

                bottom--;

            }

            if(left<=right)

            {

                for(int i=bottom;i>=top;i--)

                {

                    list.add(matrix[i][left]);

                }

                left++;

            }

        }

        return list;
    }
}
