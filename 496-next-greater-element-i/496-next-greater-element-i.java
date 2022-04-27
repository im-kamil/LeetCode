class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        
        for(int i=0; i<nums2.length; i++){
            int nextGreat=-1;
            for(int x=i+1; x<nums2.length;x++){
                if(nums2[x]>nums2[i]){
                    nextGreat=nums2[x];
                    break;
                }
            }
        nextGreater.put(nums2[i], nextGreat);
        }
        int[] output = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
             output[i] = nextGreater.get(nums1[i]);
        }
        return output;
    }
}