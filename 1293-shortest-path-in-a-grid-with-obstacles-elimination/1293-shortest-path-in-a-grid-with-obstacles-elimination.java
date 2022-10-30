class Node {
    int x;
    int y;
    int live;
    public Node(int a, int b, int k) {
        this.x = a;
        this.y = b;
        this.live = k;
    }
}
class Solution {
    private int[] dir = new int[] {-1, 0, 1, 0, -1};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
                
        Queue<Node> q = new LinkedList<>();
        Node initial = new Node(0, 0, k);
        q.add(initial);
        
        int[][] visited = new int[m][n];
        
        for (int i = 0; i < m; i++) Arrays.fill(visited[i], -1);        
        visited[0][0] = k;
                
        int res = 0;
        while (!q.isEmpty()) {            
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.live < 0) continue;
                if (curr.x == m - 1 && curr.y == n - 1) return res;
                
                for (int j = 1; j < 5; j++) {
                    int nx = curr.x + this.dir[j - 1];
                    int ny = curr.y + this.dir[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n)
                    {
                        int newlive = (grid[nx][ny] == 1 ? curr.live - 1 : curr.live);
                        if (newlive > visited[nx][ny]) {
                            visited[nx][ny] = newlive;
                            q.add(new Node(nx, ny, newlive));
                        }
                    }
                }                
            }
            res += 1;
        }
        
        return -1;
    }
}