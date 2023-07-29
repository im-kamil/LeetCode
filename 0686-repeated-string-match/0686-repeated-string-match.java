class Solution {
    public int repeatedStringMatch(String A, String B) {
        // String as = a;
        // for (int rep = 1; rep <= b.length() / a.length() + 2; rep++, as += a)
        //     if (as.indexOf(b) != -1) return rep;
        // return -1;
         String strA = A;
        int repeat = B.length()/ A.length();
        int count = 1;
        for(int i =0; i<repeat+2; i++){
            if(A.contains(B)) return count++;
            else{
                A+=strA;
                count++;
            }
        }
        return -1;
    }
}