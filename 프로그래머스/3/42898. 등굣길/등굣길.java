class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;
        
        // 집에서 학교까지 갈 수 있는 최단 경로의 개수 
        // 오른쪽과 아래쪽으로만 움직임 
        // -> 되돌아가거나 사이클이 생길 일이 없음. = 모든 경로가 최단 경로
        
        // 집: 0행, 0열
        // 학교: n-1 행, m-1 열
        
        int[][] dp = new int[n][m];
        
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        dp[0][0] = 1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j]==-1) continue;
                
                // 위에서 오는 경로 수 합치기
                if(i>0 && dp[i-1][j] != -1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % mod;
                
                // 왼쪽에서 오는 경로의 수 합치기
                if(j>0 && dp[i][j-1] != -1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % mod;
            }
        }
        
        return dp[n-1][m-1];
    }
}