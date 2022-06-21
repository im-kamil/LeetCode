class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int brickUsed = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int reach;
        for(reach=0; reach<n-1; reach++){
            if(heights[reach]>=heights[reach+1])
                continue;
            int heightDiff = heights[reach+1] - heights[reach];
            
            if(brickUsed + heightDiff<=bricks){
                brickUsed+=heightDiff;
                pq.add(heightDiff);
                
            }else if(ladders>0){
                
                if(!pq.isEmpty() && pq.peek()>heightDiff){
                    brickUsed = brickUsed - pq.poll() + heightDiff;
                    pq.add(heightDiff);
                }
                ladders--;
            }
            else break;
        }
        return reach;
    }
}