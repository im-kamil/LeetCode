class Solution {
    public int numberOfSteps(int num) {
        return Integer.toBinaryString(num).length() - 1 + Integer.bitCount(num);
    }
}