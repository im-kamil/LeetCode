class Solution {
    public int peakIndexInMountainArray(int[] A) {
         for (int i = 1; i + 1 < A.length; ++i) if (A[i] > A[i + 1]) return i;
        // for (int i = A.length - 1; i > 0; --i) if (A[i] > A[i - 1]) return i;
        return 0;
    }
}