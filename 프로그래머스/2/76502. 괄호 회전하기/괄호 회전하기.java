import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean result = true;

            // 1차 for문 (i부터 끝까지)
            for (int j = i; j < s.length(); j++) {
                char temp = s.charAt(j);

                if (temp == '[' || temp == '(' || temp == '{') {
                    stack.push(temp);
                } else {
                    if (stack.empty()) {
                        result = false;
                        break;
                    }
                    if (temp == ']' && stack.peek() != '[') {
                        result = false;
                        break;
                    }
                    if (temp == ')' && stack.peek() != '(') {
                        result = false;
                        break;
                    }
                    if (temp == '}' && stack.peek() != '{') {
                        result = false;
                        break;
                    }
                    stack.pop();
                }
            }

            // 2차 for문 (0부터 i-1까지)
            for (int j = 0; j < i && result; j++) {
                char temp = s.charAt(j);

                if (temp == '[' || temp == '(' || temp == '{') {
                    stack.push(temp);
                } else {
                    if (stack.empty()) {
                        result = false;
                        break;
                    }
                    if (temp == ']' && stack.peek() != '[') {
                        result = false;
                        break;
                    }
                    if (temp == ')' && stack.peek() != '(') {
                        result = false;
                        break;
                    }
                    if (temp == '}' && stack.peek() != '{') {
                        result = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (result && stack.empty()) {
                answer++;
            }
        }

        return answer;
    }
}
