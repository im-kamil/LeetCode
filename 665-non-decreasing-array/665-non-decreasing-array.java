class Solution {
    public boolean checkPossibility(int[] arr) {
         int count = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                if(i == 1 || arr[i-2] <= arr[i]){
                    arr[i-1] = arr[i];count++;
                }else{
                    arr[i] = arr[i-1];count++;
                }
            }
        }
        return count <= 1;
    }
}