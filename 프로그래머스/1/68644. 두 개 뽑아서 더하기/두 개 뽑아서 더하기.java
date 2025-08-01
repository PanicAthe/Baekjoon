import java.util.Arrays;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new java.util.HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int index = 0;
        for (int num : set) {
            answer[index++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
}