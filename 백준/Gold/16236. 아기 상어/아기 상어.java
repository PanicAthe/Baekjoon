import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[][] map;
    // 아기 상어 크기
    static int size = 2;
    // 아기 상어 위치
    static int pos;
    // 아기 상어가 현재 크기에서 먹은 물고기 수
    static int count;
    // 도움을 요청하기 까지 걸린 초
    static int time = 0;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    

    // 아기 상어가 물고기 먹는지 확인
    static boolean bfs(){

        boolean result = false;
        boolean[][] visited = new boolean[N][N];
        
        // 위치와 거리를 저장
        PriorityQueue<int[]> que = new PriorityQueue<>( (a,b) -> {
            // 우선순위는 거리 ASC, X ASC, Y ASC
            if(a[2]==b[2]){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }else{
                    return a[0]-b[0];
                }
            }else{
                return a[2]-b[2]; 
            }
        });
        que.offer(new int[]{pos/N, pos%N, 0});
        visited[pos/N][pos%N] = true;

        while(!que.isEmpty() && !result){
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 현재 위치 물고기를 잡아 먹을 수 있음
            if(map[x][y]<size && map[x][y]!=0){
                result = true;
                time += dist;
                pos = x*N+y;
                count++;
                if(count==size){
                    size++;
                    count=0;
                }
                map[x][y] = 0;
                return true;
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0||nx>=N||ny<0||ny>=N||map[nx][ny]>size||visited[nx][ny]) continue;
                que.offer(new int[]{nx, ny, dist+1});
                visited[nx][ny] = true;
            }
        }

        return result;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            int[] in = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s->Integer.parseInt(s)).toArray();
            for(int j=0; j<N; j++){
                map[i][j] = in[j];
                if(map[i][j]==9){
                    pos = i*N + j;
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            if(!bfs()) break;
        }
        
        System.out.print(time);
    }
}