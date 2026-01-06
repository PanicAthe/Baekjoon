import java.util.*;

class Solution {
    int n;
    int[] weak;
    int[] dist;
    int[] spreadWeak; // 2배로 늘린 취약점 배열
    boolean[] visitedFriends; // 순열 생성용 방문 체크
    int answer;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        this.answer = dist.length + 1; // 최솟값 비교를 위해 초기화

        spreadWeak = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            spreadWeak[i] = weak[i];
            spreadWeak[i + weak.length] = weak[i] + n;
        }

        visitedFriends = new boolean[dist.length];

        // 2. 친구를 투입하는 순서(순열) 만들기 시작
        permutation(0, new int[dist.length]);

        // 답을 못 찾은 경우 -1 반환
        if (answer > dist.length) return -1;
        return answer;
    }

    public void permutation(int cnt, int[] friends) {
        // 가지치기: 이미 구한 최솟값보다 더 많이 친구를 쓰고 있다면 중단
        if (cnt >= answer) return;

        // 친구가 1명 이상 뽑혔을 때, 이 조합으로 커버 가능한지 바로 확인
        if (cnt > 0) {
            check(friends, cnt);
        }
        
        // 모든 친구를 다 줄 세웠으면 종료
        if (cnt == dist.length) return;

        for (int i = 0; i < dist.length; i++) {
            if (!visitedFriends[i]) {
                visitedFriends[i] = true;
                friends[cnt] = dist[i]; // i번째 친구를 cnt 순서에 배치
                permutation(cnt + 1, friends);
                visitedFriends[i] = false;
            }
        }
    }

    // 현재 친구 순서(friends)로 모든 취약점 점검 가능한지 확인
    public void check(int[] friends, int friendCnt) {
        // 모든 취약점 지점(start)을 시작점으로 테스트
        for (int start = 0; start < weak.length; start++) {
            
            int cursor = start; 
            boolean possible = false;
            
            // 정해진 친구 순서대로 투입
            for (int i = 0; i < friendCnt; i++) {
                // 현재 친구가 커버할 수 있는 최대 위치 = (시작점 값 + 이동거리)
                int coverRange = spreadWeak[cursor] + friends[i];
                
                // 커버 범위 내에 있는 취약점들은 모두 패스
                while (cursor < start + weak.length && spreadWeak[cursor] <= coverRange) {
                    cursor++;
                }
                
                // 모든 취약점을 다 덮었으면 성공
                if (cursor >= start + weak.length) {
                    possible = true;
                    break;
                }
            }
            
            if (possible) {
                answer = Math.min(answer, friendCnt);
                return; 
            }
        }
    }
}