class Solution {
    public int concatenatedBinary(int n) {
         final long modulo = (long) (1e9 + 7);
        long result = 0;

        // This records the number of binaryDigits we need to shift left.
        int binaryDigits = 0;

        for (int i = 1; i <= n; i++) {

            // If i is a power of 2, we add one additional binaryDigits to shift.
            // Example:
            // i = 8 (1000), i-1 = 7 (111)
            // i & (i-1) = 1000 & 111 = 0
            // So we know we have increased the binaryDigits from 3 (in 111) to 4 (in 1000).
            if ((i & (i - 1)) == 0) {
                binaryDigits++;
            }

            // With the updated binaryDigits, we now can concatenate i to the result.
            // Each time get the remainder of the result % modulo.
            // Example:
            // i = 2
            // result = 1 (1) << 2 (n position) + 10 (2) = 100 (4) + 10 (2) = 110 (6).
            // i = 3
            // result = 110 (6) << 2 (n position) + 11 (3) = 11000 (24) + 11 (3) = 11011 (27).
            //
            result = ((result << binaryDigits) + i) % modulo;
        }
        return (int) result;
    }
}