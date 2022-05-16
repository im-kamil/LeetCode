class Solution {
    public int minimumCost(int[] cost) {
         Arrays.sort(cost);
        int minCost=0;
        int c=0;
        for(int i=cost.length-1;i>=0;i--){
            if(c==2){
                c=0;
            }else{
                minCost+=cost[i];
                c++;
            }
        }
        return minCost;
    }
}