import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        return Arrays.stream(intervals)
                .flatMapToInt(interval -> Arrays.stream(arr, interval[0], interval[1] + 1))
                .toArray();
    }
}
