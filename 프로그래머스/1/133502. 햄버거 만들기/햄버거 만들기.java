import java.util.LinkedList;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);
            if (stack.size() >= 4) {
                //햄버거 완성인지 검사
                if (stack.get(stack.size() - 1) == 1 &&
                    stack.get(stack.size() - 2) == 3 &&
                    stack.get(stack.size() - 3) == 2 &&
                    stack.get(stack.size() - 4) == 1) {
                    stack.removeLast();
                    stack.removeLast();
                    stack.removeLast();
                    stack.removeLast();
                    answer++;
                }
            }
        }

        return answer;
    }
}