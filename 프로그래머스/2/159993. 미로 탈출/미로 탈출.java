import java.util.*;

class Solution {
    
    class Position{
        int x;
        int y;
        
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int n = maps.length;
        int m = maps[0].length();
        
        char[][] map = new char[n][m];
        Queue<Position> que = new ArrayDeque<>();
        Position lever = null;
        Position start = null;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j]=='S'){
                    start = new Position(i, j);
                }
            }
        }
        
        // 시작 점부터 레버까지 steps
        boolean[][] visited = new boolean[n][m];
        int[][] stepsToL = new int[n][m];
        que.add(start);
        visited[start.x][start.y] = true;
        
        while(!que.isEmpty()){
            Position cur = que.poll();
            for(int i=0; i<4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                
                if(x<0||y<0||x>=n||y>=m||visited[x][y]) continue;
                
                //레버인지 체크
                if(map[x][y] == 'L'){
                    lever = new Position(x, y);
                    visited[x][y] = true;
                    stepsToL[x][y] = stepsToL[cur.x][cur.y] + 1;
                    break;
                }
                
                if(map[x][y]=='X') continue;
                
                visited[x][y] = true;
                stepsToL[x][y] = stepsToL[cur.x][cur.y] + 1;
                que.add(new Position(x, y));
            }
        }
        
        
        // 레버에서 출구까지
        visited = new boolean[n][m];
        int[][] stepsToE = new int[n][m];
        if(lever==null){
            return -1;
        }
        que.add(lever);
        visited[lever.x][lever.y] = true;
        
        while(!que.isEmpty()){
            Position cur = que.poll();
            for(int i=0; i<4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                
                if(x<0||y<0||x>=n||y>=m||visited[x][y]) continue;
                
                //출구인지 체크
                if(map[x][y] == 'E'){
                    visited[x][y] = true;
                    return stepsToL[lever.x][lever.y] + stepsToE[cur.x][cur.y] + 1;
                }
                if(map[x][y]=='X') continue;
                
                visited[x][y] = true;
                stepsToE[x][y] = stepsToE[cur.x][cur.y] + 1;
                que.add(new Position(x, y));
            }
        }
        
        return -1;
    }
}