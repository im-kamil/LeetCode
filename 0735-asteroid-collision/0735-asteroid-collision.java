class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //  LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        // for (int i = 0; i < a.length; i++) {
        //     if (a[i] > 0 || s.isEmpty() || s.getLast() < 0)
        //         s.add(a[i]);
        //     else if (s.getLast() <= -a[i])
        //         if (s.pollLast() < -a[i]) i--;
        // }
        // return s.stream().mapToInt(i->i).toArray();
         Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            //if stack is empty or a positve value arrives then perform blind insertion
            if(stack.isEmpty() || asteroids[i]>0){
                stack.push(asteroids[i]);
            } else {
                while(!stack.isEmpty()){
                    int top = stack.peek();
                    if(top<0){
                        stack.push(asteroids[i]);
                        break;
                    } 
                    int modVal = Math.abs(asteroids[i]);
                        if(modVal == top){
                            stack.pop();
                            break;
                        } else if(modVal < top){
                            break;
                        } else {
                            stack.pop();
                            if(stack.isEmpty()){
                                stack.push(asteroids[i]);
                                break;
                            }
                        }
                    
                }
            }
        }
        int len = stack.size();
        int ansArray[] = new int[len];
        for(int i=len-1;i>=0;i--){
            ansArray[i] = stack.pop();
        }
        return ansArray;
    }
}