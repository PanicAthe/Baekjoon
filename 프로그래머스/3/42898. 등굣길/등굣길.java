class Solution {
    public int solution(int m, int n, int[][] puddles) {  
        
        // dp[i][j] : (i, j) 좌표까지의 최단 거리 경로 개수
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        
        // 물 웅덩이 표시
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j]==-1){
                    continue;
                }
                
                // 위쪽 경로 더하기
                if(i>0 && dp[i-1][j]!=-1) dp[i][j] = (dp[i][j]+dp[i-1][j])%1_000_000_007;
                
                // 왼쪽 경로 더하기
                if(j>0 && dp[i][j-1]!=-1) dp[i][j] = (dp[i][j]+dp[i][j-1])%1_000_000_007;
            }
        }
        
        return dp[m-1][n-1];
    }
}