import java.util.*;

class Solution {
    
    class Position{
        int x;
        int y;
        int direction;
        
        public Position(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dist = new int[n][n][4];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                 Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;
        dist[0][0][2] = 0;
        dist[0][0][3] = 0;
        
        Queue<Position> que = new LinkedList<>();
        que.add(new Position(0, 0, 0));
        while(!que.isEmpty()){
            Position cur = que.poll();
            for(int i=0; i<4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                
                // 범위 밖이고 벽이면 제외
                if(x<0||y<0||x>=n||y>=n||board[x][y]==1) continue;
                
                int direction;
                if(dx[i]==1&&dy[i]==0){
                    direction = 0;
                }else if(dx[i]==-1&&dy[i]==0){
                    direction = 1;
                }else if(dy[i]==1&&dx[i]==0){
                    direction = 2;
                }else{
                    direction = 3;
                }
                
                // 현재 원점이라면 그냥 큐에 넣기
                if(cur.x==0&&cur.y==0){
                    que.add(new Position(x, y, direction));
                    // 직선 도로로 처리
                    dist[x][y][direction] = 100;
                }else{
                    int cost = 600;
                    // 직전 방향이랑 같은 방향이라면 직선 도로
                    if(cur.direction == direction){
                        cost = 100;
                    }
                    // 최소 거리 업데이트 되면 큐에 넣기
                    if(dist[x][y][direction] > dist[cur.x][cur.y][cur.direction] + cost){
                        dist[x][y][direction] = dist[cur.x][cur.y][cur.direction] + cost;
                        que.add(new Position(x, y, direction));
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<4; i++){
            answer = Math.min(answer, dist[n-1][n-1][i]);
        }
        return answer;
    }
}