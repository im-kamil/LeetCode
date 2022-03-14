class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int[] arr = new int[nums1.length + nums2.length];
        int left=0;
        int right=0;
        int i =0;
        while(right < nums2.length && left<nums1.length){
            if(nums1[left]>nums2[right]){
                arr[i++] = nums2[right++];
            }
            else{
                arr[i++] = nums1[left++];
            }
        }
        while(right < nums2.length){
            arr[i++]=nums2[right++];
        }
        while(left < nums1.length){
            arr[i++]=nums1[left++];
        }
        double res =0.0;
        if(arr.length%2 == 0){
            int mid = arr.length/2;
                res = (double)(arr[mid]+arr[mid-1])/2;
            }
        else{
            res = arr[arr.length/2];}
        return res;
    }
}