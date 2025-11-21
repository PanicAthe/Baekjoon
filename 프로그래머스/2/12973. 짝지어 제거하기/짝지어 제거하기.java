import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        System.out.println("Hello Java");

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char input = s.charAt(i);
            if(stack.isEmpty()||stack.peek()!=input){
                stack.push(input);
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}