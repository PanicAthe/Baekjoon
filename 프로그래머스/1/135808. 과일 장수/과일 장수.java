import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        // 점수 내림차순 정렬
        Arrays.sort(score);
        
        int sum = 0;
        int n = score.length;
        
        // 큰 점수부터 m개씩 묶어서 최소값 * m
        for (int i = n - m; i >= 0; i -= m) {
            sum += score[i] * m; // score[i]가 해당 묶음 중 최소값
        }
        
        return sum;
    }
}
