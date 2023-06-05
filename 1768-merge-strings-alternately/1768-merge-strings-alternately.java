class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        
        char[] resultArr = new char[length1 + length2];
        
        // Two pointers are maintained which will be used to 
        // fetch the characters in alternating order.       
        int pointer1 = 0, pointer2 = 0, resultPointer = 0;
        
        //When either of the word's traversal is completed then loop
        //will only consider the other word.
        while (pointer1 < length1 || pointer2 < length2) {
            if (pointer1 < length1) {
                resultArr[resultPointer++] = word1.charAt(pointer1++);
            }
            if (pointer2 < length2) {
                resultArr[resultPointer++] = word2.charAt(pointer2++);
            }
        }
        // return new String(resultArr);
        return new String(resultArr);
        // StringBuilder  sb = new StringBuilder();
        // int n1 = word1.length();
        // int n2 = word2.length();
        // int i =0;
        // while(i<n1 || i<n2){
        //     if(i<n1)  sb.append(word1.charAt(i));
        //     if(i<n2) sb.append(word2.charAt(i));
        // }
        // return sb.toString();
    }
}