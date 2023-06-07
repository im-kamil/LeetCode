class Solution {
    public int minFlips(int a, int b, int c) {
        // int res = 0;
        // while (a != 0 || b != 0 || c != 0) {
        //     int t = a & 1;
        //     int m = b & 1;
        //     int n = c & 1;
        //     if ((t | m) != n) {
        //         if (n == 0) {
        //             if (t == 1) {
        //                 res++;
        //             }
        //             if (m == 1) {
        //                 res++;
        //             }
        //         } else {
        //             res++;
        //         }
        //     }
        //     a = a >> 1;
        //     b = b >> 1;
        //     c = c >> 1;
        // }
        // return res;
         int ans = 0, ab = a | b, equal = ab ^ c;
        for (int i = 0; i < 31; ++i) {
            int mask = 1 << i;
            if ((equal & mask) > 0)  // ith bits of a | b and c are not same, need at least 1 flip.
             // ans += (ab & mask) < (c & mask) || (a & mask) != (b & mask) ? 1 : 2;
                ans += (a & mask) == (b & mask) && (c & mask) == 0 ? 2 : 1; // ith bits of a and b are both 1 and that of c is 0?
        }
        return ans;
    }
}