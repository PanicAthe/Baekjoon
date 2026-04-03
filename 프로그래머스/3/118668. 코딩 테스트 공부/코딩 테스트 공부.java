import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        // 각 힘 1을 높이기 위해서는 1시간 필요
        // 풀 수 있는 문제 중 하나를 풀어 힘을 높임. (올라가는 알고/코딩 힘 정해져있음)
        // 문제를 하나 푸는데 요구하는 시간이 있고 중복으로 푸는 것도 가능
        
        // 리턴: 모든 문제를 풀 수 있는 힘을 얻는 최단 시간 
        // 초기 알고력 alp, 초기 코딩력 cop
        
        // problems[i] : 각 문제의 필요 alp, 필요 cop, 증가 alp, 증가 cop, 소요 시간
        
        // 최소로 만족해야하는 힘
        int targetA = alp;
        int targetC = cop;
        for(int i=0; i<problems.length; i++){
            targetA = Math.max(problems[i][0], targetA);
            targetC = Math.max(problems[i][1], targetC);
        }
        
        // dp[i][j] : 알고력 i, 코딩력 j 까지의 최소 시간
        int[][] dp = new int[targetA+1][targetC+1];
        for(int i=0; i<=targetA; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i=0; i<=alp; i++){
            for(int j=0; j<=cop; j++){
                dp[i][j] = 0;
            }
        }
        
        for(int i=0; i<=targetA; i++){
            for(int j=0; j<=targetC; j++){
                
                // 1시간 공부
                if(i<targetA) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                if(j<targetC) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                // 문제 풀기
                for(int p=0; p<problems.length; p++){
                    // 풀 수 없는 문제라면 패스
                    if(problems[p][0]>i || problems[p][1]>j) continue;
                    
                    // 문제를 푼 이후 힘
                    int a = Math.min(targetA, problems[p][2] + i);
                    int c = Math.min(targetC, problems[p][3] + j);
                    
                    // 해당 힘까지 걸리는 최소 시간
                    dp[a][c] = Math.min(dp[a][c], dp[i][j] + problems[p][4]);
                }
            }
        }
        return dp[targetA][targetC];
    }
}