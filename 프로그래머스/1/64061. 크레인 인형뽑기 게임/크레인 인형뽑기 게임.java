import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stack = new Stack[board.length];   
        Stack<Integer> getStack = new Stack<>();    

        for (int i = 0; i < board.length; i++) {
            stack[i] = new Stack<Integer>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    stack[j].push(board[i][j]);
                }
            }
        }

        for (int move : moves) {
            int column = move - 1;
            if (!stack[column].isEmpty()) {
                int top = stack[column].pop();
                if( !getStack.isEmpty() && getStack.peek() == top) {
                    getStack.pop();
                    answer += 2; 
                }else{
                    getStack.push(top);
                }
            }
        }

        return answer;
    }
}