class Solution {
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K-1) & 1;
    }
}