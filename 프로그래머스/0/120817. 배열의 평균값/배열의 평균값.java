import java.util.Arrays;

class Solution {
    public double solution(int[] numbers) {
        double answer = Arrays.stream(numbers).sum();
        return answer/numbers.length;
    }
}