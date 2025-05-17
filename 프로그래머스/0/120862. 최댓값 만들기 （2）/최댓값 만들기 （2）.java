import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        int max = Math.max(numbers[n-2]*numbers[n-1], numbers[0]*numbers[1]);
        return max;
    }
}