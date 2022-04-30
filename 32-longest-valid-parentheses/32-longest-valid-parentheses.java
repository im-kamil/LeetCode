class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> st = new Stack();
        Stack<Integer> index = new Stack();
        int max=0;
        index.add(-1);
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.add('(');
                index.add(i);
            }else{
                // closing bracket
                if(!st.isEmpty()&&st.peek()=='('){
                    st.pop(); // htado st and index
                    index.pop();
                    // now calculate length
                    max = Math.max(max, i-index.peek());
                }else{
                    index.add(i);
                }
            }
       }
        return max;
    }
}