class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 처음부터 끝까지 쭉 오른쪽으로 가는 경우
        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            // 상하 조작
            char target = name.charAt(i);
            answer += Math.min(target - 'A', 'Z' - target + 1);

            // 좌우 조작
            // 현재 위치 다음에 연속된 'A'가 끝나는 지점
            int nextIdx = i + 1;
            while (nextIdx < n && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            // 오른쪽으로 i만큼 갔다가, 다시 원점으로 돌아와, 왼쪽 끝으로 이동(
            minMove = Math.min(minMove, i * 2 + (n - nextIdx));
            
            // 처음부터 왼쪽 끝으로 가서, 다시 원점으로 돌아와, i까지 이동
            minMove = Math.min(minMove, (n - nextIdx) * 2 + i);
        }

        return answer + minMove;
    }
}