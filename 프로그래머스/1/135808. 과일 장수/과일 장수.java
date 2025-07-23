import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        // 점수 내림차순 
        Arrays.sort(score);
        
        int sum = 0;
        int n = score.length;
        
        // 큰 점수부터 m개씩 
        for (int i = n - m; i >= 0; i -= m) {
            sum += score[i] * m; 
        }
        
        return sum;
    }
}
