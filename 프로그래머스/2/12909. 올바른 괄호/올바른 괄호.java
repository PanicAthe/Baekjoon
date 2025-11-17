import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (temp == '(') {
                stack.push(temp);
            } else if (temp == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.empty();
    }
}
