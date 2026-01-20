import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i<=d/k; i++){
            long x = i*k;
            long maxY = (long) Math.sqrt((long) d*d - x*x);
            answer += (int) maxY / k + 1;
        }
        
        return answer;
    }
}