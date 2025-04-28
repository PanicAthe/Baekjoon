import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        int[] answer = Arrays.copyOf(num_list, 5);
        return answer;
    }
}