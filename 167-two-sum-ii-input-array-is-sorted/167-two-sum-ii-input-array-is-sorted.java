class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start =0; int end = numbers.length-1;
        
        while(start<end){
            if(numbers[start]+numbers[end]>target){
                end--;
            }else if(numbers[start]+numbers[end]<target){
                start++;
            }else{
                return new int[]{start+1,end+1}; // coz questions is saying starts from 1 index so +1 we add in result
            }
        }
        return new int[]{};
    }
}