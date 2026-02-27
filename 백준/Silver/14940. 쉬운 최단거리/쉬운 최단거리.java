import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" "))
            .mapToInt(str -> Integer.parseInt(str))
            .toArray();
        // 세로 크기
        int N = temp[0];
        // 가로 크기
        int M = temp[1];

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) Arrays.fill(map[i], -1);

        int[] target = new int[2];
        for(int i=0; i<N; i++){
            int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(str -> Integer.parseInt(str)).toArray();
            for(int j=0; j<M; j++){
                if(nums[j]==2){
                    target[0] = i;
                    target[1] = j;
                    map[i][j] = 0;
                }else if(nums[j]==0){
                    map[i][j]=0;
                }
            }
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        Deque<int[]> que = new LinkedList<>();
        que.offer(target);
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int x = curX + dx[i];
                int y = curY + dy[i];
                if(x<0||x>=N||y<0||y>=M||map[x][y]!=-1) continue;
                map[x][y] = map[curX][curY] + 1;
                que.offer(new int[]{x, y});
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}