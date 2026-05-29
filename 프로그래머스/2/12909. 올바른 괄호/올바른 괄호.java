import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()){
            if (stack.isEmpty() && ch == ')') {
                return false;
            }
            
            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}