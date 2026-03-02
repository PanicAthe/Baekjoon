import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = Arrays.stream(br.readLine().split(" "))
            .mapToInt(s->Integer.parseInt(s)).toArray();

        int N = temp[0];
        int M = temp[1];

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int answer = Integer.MAX_VALUE;
        
       int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j) - '0';
                dist[i][j] = -1;
            }            
        }

        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];

            if(curX == N-1 && curY == M-1) break;
            
            for(int i=0; i<4; i++){
                int x = curX + dx[i];
                int y = curY + dy[i];
                if(x<0||x>=N||y<0||y>=M||map[x][y]==0||dist[x][y]!=-1) continue;
                dist[x][y] = dist[curX][curY] + 1;
                que.offer(new int[]{x, y});
            }
        }
        
        System.out.print(dist[N-1][M-1]);
        
    }
}