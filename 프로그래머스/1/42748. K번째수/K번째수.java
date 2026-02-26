import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            .mapToInt(command -> {
                int start = command[0] - 1;
                int end = command[1] - 1;
                int k = command[2] - 1;

                int[] sub = Arrays.copyOfRange(array, start, end + 1);
                Arrays.sort(sub);
                return sub[k];
            })
            .toArray();
    }
}