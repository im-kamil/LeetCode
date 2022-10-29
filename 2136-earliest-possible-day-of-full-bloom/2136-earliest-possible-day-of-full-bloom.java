class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
                int n  = plantTime.length;
		//create a multi-dim array
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = growTime[i];
            arr[i][1] = plantTime[i];
        }
		//sort array according to max grow time first
        Arrays.sort(arr,(a,b)->(b[0]-a[0]));
        int time=0;
        int max=0;
		//plant max grow time first and keep track of max time it can take
        for(int i=0;i<n;i++){
            time += arr[i][1];
            max = Math.max(max,time+arr[i][0]);
        }
        return max;

    }
}