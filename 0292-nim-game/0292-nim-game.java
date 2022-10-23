class Solution {
    public boolean canWinNim(int n) {
        return (n & 0b11) != 0;
    }
}