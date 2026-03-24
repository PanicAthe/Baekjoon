import java.util.*;

class Solution {

    public int solution(int[][] land, int height) {
        
        // 칸 이동은 상,하,좌,우
        // 현재 칸과 이동하려는 칸 높이차는 height 이하
        // 높이 차가 사다리 설치 비용
        // 출력: 모든 칸을 방문하기 위해 필요한 사다리 설치 비용의 최솟값
        int N = land.length;
        boolean[][] visited = new boolean[N][N];
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        
        pq.offer(new int[]{0,0,0}); // x, y, cost
        int answer = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            
            if(visited[x][y]) continue;
            visited[x][y] = true;
            answer += cost;
            
            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;
                
                int diff = Math.abs(land[x][y] - land[nx][ny]);
                if(diff <= height) diff = 0;
                
                pq.offer(new int[]{nx, ny, diff});
            }
        }
        
        return answer;
    }
}