import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        
        // dp: (현재까지 만들 수 있는 합, 그 합을 만드는 경우의 수)
        Map<Integer, Integer> dp = new HashMap<>();
        
        dp.put(0, 1); // 합 0을 만드는 방법은 1가지 (초기 상태)

        for (int num : numbers) {
            // 현재 숫자까지 고려했을 때의 결과 저장
            Map<Integer, Integer> next = new HashMap<>();

            // 이전 단계의 모든 합에 대해
            for (int sum : dp.keySet()) {
                
                // 해당 합을 만들 수 있는 경우의 수
                int count = dp.get(sum);
                
                // 현재 숫자를 더하거나 빼서 새로운 합 생성
                // 이미 같은 합이 존재하면 경우의 수 누적
                next.put(sum + num, next.getOrDefault(sum + num, 0) + count);
                next.put(sum - num, next.getOrDefault(sum - num, 0) + count);
            }

            dp = next; 
        }

        return dp.getOrDefault(target, 0);
    }
}