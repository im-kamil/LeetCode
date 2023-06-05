class Solution {
        public boolean canPlaceFlowers(int[] bed, int n) {
        int counter = 0;
        for (int i = 0; i < bed.length; i++) {
            int left = i == 0 ? 0 : bed[i - 1];
            int right = i == bed.length - 1 ? 0 : bed[i + 1];
            if (left == 0 && right == 0 && bed[i] == 0) {
                bed[i] = 1;
                counter++;
            }
        }

        return counter >= n;
//             int count =0;
//             for(int i=0;i<bed.length; i++){
//                 if(bed[i] == 0) {
//                     int prev = (i==0 || bed[i-1]==0)?0:1;
//                     int next = (i==bed.length-1 || bed[i+1]==0)?0:1;
                    
//                     if(prev==0 && next==0) bed[i]=1;
//                      count++;
//                 }
//             }
//             return count>=n;
    }
}