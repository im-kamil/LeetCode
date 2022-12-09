//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        // add your code here
         int dir[][]={{-2,-1},{-2,1},{2,-1},{2,1},{-1,2},{1,2},{-1,-2},{1,-2}};

 

                int mod=(int)1e9+7;

 

        long ans=0l;

 

        

 

        for(int i=0;i<N;i++)

 

        {

 

            for(int j=0;j<M;j++)

 

            {

 

                long curr=N*M;

 

                long Possible=1l;

 

                for(int k=0;k<dir.length;k++)

 

                {

 

                    int x=i+dir[k][0];

 

                    int y=j+dir[k][1];

 

                    

 

                    if(valid(x,y,N,M))

 

                        Possible++;

 

                    

 

                }

 

                curr-=Possible;

 

                ans=(ans+curr)%mod;

 

            }

 

        }

 

        return ans%mod;

 

    }

 

    public static boolean valid(int x,int y,int N,int M)

 

    {

 

        if(x<0||y<0||x>=N||y>=M)

 

        return false;

 

        

 

        return true;

 
    }
}