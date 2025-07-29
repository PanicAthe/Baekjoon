class Solution {
    public long solution(int price, int money, int count) {
        long answer = -money;
        for (int i = 1; i <= count; i++) {
            answer += price * i;
        }
        return Math.max(answer, 0);
    }
}
