class Solution {
    public int[] productExceptSelf(int[] nums) {
//       int len = nums.length,product = 1;
//         int[] res = new int[len];
		
//         for(int i=0;i<len;i++)
//         {
//             int e = nums[i];
//             res[i] = product; // store product of all elements to left of current element in res[i]
//             product *= e; // maintain product variable
//         }
        
//         product = 1; // reset product
        
//         for(int i=len-1;i>=0;i--)
//         {
//             int e = nums[i];
//             res[i] *= product; // multiply product of all elements to right(product) to res[i] which is product of all elements to the left of current element
//             product *= e;
//         }
        
//         return res;
        int[] result = new int[nums.length];
        int temp=1;
        // first pass 
        for(int i=0;i<nums.length;i++){
            result[i] = temp;
            temp*=nums[i];
        }
        // second pass
        temp=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i] *= temp;
            temp*=nums[i];
            
        }
        return result;
    }
}    