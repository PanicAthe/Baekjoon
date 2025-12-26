import java.util.*;
class Solution {
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    class Position{
        int x;
        int y;
        
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
              
    public int solution(int[][] maps) {
        
        int n = maps.length; //행
        int m = maps[0].length; //열
        int[][] steps = new int[n][m];
        Queue<Position> que = new LinkedList<>();
        
        que.add(new Position(0, 0));
        steps[0][0] = 1; //걸음수 기록
        
        //bfs
        while(!que.isEmpty()){
            Position cur = que.poll();
            for(int i=0; i<4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if(x<0||y<0||x>=n||y>=m||steps[x][y]!=0||maps[x][y]==0) continue;
                steps[x][y] = steps[cur.x][cur.y] + 1;
                que.add(new Position(x, y));
            }
        }
                
        return (steps[n-1][m-1]==0)? -1 : steps[n-1][m-1];
    }
}