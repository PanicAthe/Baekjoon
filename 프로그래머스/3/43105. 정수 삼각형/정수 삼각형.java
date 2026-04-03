import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], 0);
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    // 맨 왼쪽 수는 무조건 바로 위 맨 왼쪽 수에서 내려옴
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j==i){
                    // 맨 오른쪽 수는 무조건 바로 위 맨 오른쪽 수에서 내려옴
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) answer = Math.max(answer, dp[n-1][i]);
        return answer;
    }
}