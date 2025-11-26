import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i=1; i<n; i++){
            int price = prices[i];
            // 스택이 비어있지 않고 price가 스택 top보다 작으면
            while(!stack.empty() && prices[stack.peek()]>price){
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        while(!stack.empty()){
            int j = stack.pop();
            answer[j] = n - j - 1;
        }
        
        return answer;
    }
}