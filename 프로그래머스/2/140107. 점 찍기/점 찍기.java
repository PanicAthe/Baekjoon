import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // 좌표평면 x, y 값은 k의 배수 (0, 1*k, 2*k ...)
        // 원점(0,0)과 거리가 d를 넘지 않음
        
        for(int i=0; i*k<=d; i++){
            long x = i*k;
            
            // 현재 x에서 가능한 y의 최대값
            long maxY = (long) Math.sqrt((long) d*d - x*x);
            
            // y도 k의 배수
            answer += (int) maxY / k + 1;
        }
        
        return answer;
    }
}