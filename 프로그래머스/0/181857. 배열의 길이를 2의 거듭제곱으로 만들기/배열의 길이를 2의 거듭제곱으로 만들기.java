import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        int size = 1;
        while (size < arr.length) {
            size *= 2;
        }
        answer = Arrays.copyOf(arr, size);
        return answer;
    }
}