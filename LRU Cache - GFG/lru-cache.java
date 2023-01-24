//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.
   LinkedHashMap<Integer,Integer> map;
    int MAX = 10;
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        this.MAX = cap;
        map = new LinkedHashMap<Integer,Integer>(cap,(float)0.75,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > MAX;
            }
        };
    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
        if(map.containsKey(key)) return map.get(key);
        return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        map.put(key,value);
    }

}