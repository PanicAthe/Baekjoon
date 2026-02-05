class Solution {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // dfs 반환값: 현재 상태에서 게임이 끝날 때까지 남은 총 이동 횟수
    // 짝수: 플레이어 패배 / 홀수: 플레이어 승리
    public int dfs(int[][] board, int curX, int curY, int oppX, int oppY) {
        
        // 1. 현재 서있는 발판이 이미 사라진 경우 (직전 턴에 상대가 같은 위치에서 이동해서 발판 깸)
        if (board[curX][curY] == 0) return 0;

        int ret = 0; // 리턴할 값 (최적의 이동 횟수)
        
        // 2. 이동할 수 있는 모든 곳 탐색
        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 0) continue;

            board[curX][curY] = 0; // 발판 삭제 (이동)
            
            // 상대방 턴으로 넘김 
            // val: 이번 이동 후, 상대방 입장에서 남은 턴 수
            int val = dfs(board, oppX, oppY, nx, ny);
            
            board[curX][curY] = 1; // 백트래킹 (원상복구)

            // 3. 승패 판단 로직 (Minimax)
            // val + 1 : 이번 내 움직임(1) + 상대방의 남은 움직임(val)
            
            // 핵심 논리:
            // 현재 저장된 ret가 짝수(패배)이고, 새로 계산한 val+1이 홀수(승리)라면? -> 무조건 승리 쪽을 선택
            // 둘 다 승리(홀수)라면? -> 더 빨리 이기는 것(Min) 선택
            // 둘 다 패배(짝수)라면? -> 더 늦게 지는 것(Max) 선택
            
            if (ret % 2 == 0 && (val + 1) % 2 == 1) { 
                // 나는 현재 지는 상태였는데, 이길 수 있는 수를 발견함 -> 무조건 갱신
                ret = val + 1;
            } else if (ret % 2 == 0 && (val + 1) % 2 == 0) {
                // 나도 지고, 새로운 수도 지는 경우 -> 최대한 오래 버티기 (Max)
                ret = Math.max(ret, val + 1);
            } else if (ret % 2 == 1 && (val + 1) % 2 == 1) {
                // 나도 이기고, 새로운 수도 이기는 경우 -> 최대한 빨리 이기기 (Min)
                ret = Math.min(ret, val + 1);
            }
        }

        // ret가 0이면 이동할 곳이 없다는 뜻 -> 패배 (0 반환)
        return ret;
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]);
    }
}