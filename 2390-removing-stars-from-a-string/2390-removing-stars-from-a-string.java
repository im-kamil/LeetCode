class Solution {
    public String removeStars(String s) {
    //   StringBuilder sb= new StringBuilder();
    // for(var i:s.toCharArray())
    //     if(i=='*') sb.deleteCharAt(sb.length() - 1);
    //     else sb.append(i);
    // return sb.toString();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch != '*'){
                stack.push(ch);
                
            }else{
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString();
        return result;
    }
}