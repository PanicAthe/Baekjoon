import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] box;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" "))
            .mapToInt(str -> Integer.parseInt(str))
            .toArray();
        // 상자의 가로칸 수
        int M = temp[0];
        // 상자의 세로칸 수
        int N = temp[1];


        Deque<int[]> que = new ArrayDeque<>();
        box = new int[N][M];
        for(int i=0; i<N; i++){
            int[] tomatos = Arrays.stream(br.readLine().split(" "))
                .mapToInt(str -> Integer.parseInt(str))
                .toArray();
            for(int j=0; j<M; j++){
                // 익은 토마토 위치 큐에 저장
                if(tomatos[j]==1){
                    que.offer(new int[]{i,j});    
                }
                box[i][j] = tomatos[j];
            }
        }

        // dfs로 토마토 익히기 box[i][j]에는 익은 날 메모
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i=0; i<4; i++){
                int x = curX + dx[i];
                int y = curY + dy[i];
                if(x<0||x>=N||y<0||y>=M||box[x][y]!=0) continue;
                box[x][y] = box[curX][curY] + 1;
                que.offer(new int[]{x,y});
            }
        }
        
        int answer = 0;
        // 마지막으로 익지 않은 토마토 있는지 검사
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j]==0){
                    System.out.print(-1);
                    return;
                }
                answer = Math.max(answer, box[i][j]);
            }
        }

        System.out.print(answer-1);

    }

}