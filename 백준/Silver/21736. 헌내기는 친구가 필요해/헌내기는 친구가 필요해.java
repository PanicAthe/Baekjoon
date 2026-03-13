import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        char[][] map = new char[N][M];
        Queue<Integer> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j]=='I'){
                    visited[i][j] = true;
                    que.offer(i*M+j);
                }
            }
        }

        int result = 0;
        while(!que.isEmpty()){
            int cur = que.poll();
            int curX = cur/M;
            int curY = cur%M;

            for(int i=0; i<4; i++){
                int x = curX + dx[i];
                int y = curY + dy[i];
                if(x<0||x>=N||y<0||y>=M||visited[x][y]||map[x][y]=='X') continue;
                que.offer(x*M+y);
                visited[x][y] = true;
                if(map[x][y] == 'P') result++;
            }
        }

        if(result==0){
            System.out.print("TT");
        }else{
            System.out.print(result);
        }
    }
}