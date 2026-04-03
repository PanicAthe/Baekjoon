import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        // maps의 1만 이동 가능
        // 캐릭터는 좌측 상단, 목표지는 우측 하단
        
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        int[] dist = new int[n*m];
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        dist[0] = 1;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            int curX = cur/m;
            int curY = cur%m;
            for(int i=0; i<4; i++){
                int x = curX + dx[i];
                int y = curY + dy[i];
                if(x<0||x>=n||y<0||y>=m||dist[x*m+y]!=0||maps[x][y]==0) continue;
                que.offer(x*m+y);
                dist[x*m+y] = dist[cur]+1;
            }
        }
        
        return dist[n*m-1] == 0 ? -1 : dist[n*m-1];
    }
}