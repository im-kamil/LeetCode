class Solution {
public int evalRPN(String[] a) {
  Stack<Integer> stack = new Stack<Integer>();
  
  for (int i = 0; i < a.length; i++) {
    switch (a[i]) {
      case "+":
        stack.push(stack.pop() + stack.pop());
        break;
          
      case "-":
        stack.push(-stack.pop() + stack.pop());
        break;
          
      case "*":
        stack.push(stack.pop() * stack.pop());
        break;

      case "/":
        int n1 = stack.pop(), n2 = stack.pop();
        stack.push(n2 / n1);
        break;
          
      default:
        stack.push(Integer.parseInt(a[i]));
    }
  }
  
  return stack.pop();
}
}