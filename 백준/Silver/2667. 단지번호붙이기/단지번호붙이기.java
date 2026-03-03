import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static List<Integer> list = new ArrayList<>();
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static void bfs(int startX, int startY){
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 1;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i=0; i<4; i++){
                int x = curX + dx[i];
                int y = curY + dy[i];
                if(x<0||x>=N||y<0||y>=N||map[x][y]==0||visited[x][y]) continue;
                count++;
                visited[x][y] = true;
                que.offer(new int[]{x, y});
            }
        }

        list.add(count);
        return;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
            }            
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j]==1){
                    answer++;
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(answer);
        Collections.sort(list);
        for(int n:list){
            System.out.println(n);
        }
        
    }
}