import java.util.*;
class Solution {
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        // 승객이 탑승 중인 시간에 쾌적한 실내온도를 유지하기 위한 최소 소비전력
        
        // 희망온도는 에어컨 전원이 켜져있는 동안 원하는 값으로 변경 가능
        
        // 에어컨 on: 
        // 실내온도와 희망온도가 다르다면, 1분 뒤 1도 상승 or 하강하며 가까워짐
        // 실내온도와 희망온도가 다르다면 소비 전력 a, 같다면 소비전력 b
        
        // 에어컨 off:
        // 실외온도와 실내온도가 다르다면, 1분 뒤 1도 상승 or 하강하며 가까워짐
        
        // 쾌적한 실내온도 : t1 ~ t2
        
        int n = onboard.length;

        // dp[i][j] : i분에 온도 j일때 최소 비용, +10은 영하를 표현하기 위함
        temperature += 10;
        t1 += 10;
        t2 += 10;
        int index = Math.max(t2, temperature) + 1;
        int[][] dp = new int[n][index];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], 1000000);
        
        dp[0][temperature] = 0;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<index; j++){
                // 현재 탑승 중인데 쾌적한 실내온도 못맞춰두면 실패
                if(onboard[i]==1 && (j > t2 || j < t1)) continue;
                
                // 직전 온도와 같은 경우
                if(j==temperature) dp[i][j] = dp[i-1][j];
                else if(dp[i-1][j] != 1000000) dp[i][j] = dp[i-1][j] + b;
                
                // 온도가 올라오는 경우
                if(j-1>=0){
                    // 직전 온도가 실외온도 보다 낮다면 올라가는데 비용 x
                    if(j-1<temperature){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                    }else{
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + a);
                    }
                }
                
                // 온도가 내려오는 경우
                if(j+1<index){
                    // 직전 온도가 실외온도 보다 높다면 내려가는데 비용 x
                    if(j+1>temperature){
                       dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                    }else{
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + a);
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<index; i++){
            answer = Math.min(answer, dp[n-1][i]);
        }
        return answer;
    }
}
