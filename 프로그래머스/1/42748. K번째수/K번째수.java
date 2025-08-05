import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            .mapToInt(command -> {
                int start = command[0]-1;
                int end = command[1];
                int k = command[2]-1;
                return Arrays.stream(Arrays.copyOfRange(array, start, end))
                        .sorted()
                        .toArray()[k];
            })
            .toArray();
    }
}
