class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
         Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for(int p : pushed){
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}