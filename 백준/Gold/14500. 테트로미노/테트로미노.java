import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N, M;
    static int answer = Integer.MIN_VALUE;
    static boolean[][] visited;

    static void dfs(int count, int sum, int[] set){
        if(count==4){
            if(sum>answer) answer = sum;   
            return;
        }

        // 미완성 테트로미노 테두리와 맞닿은 모든 사각형을 확인
        for(int i=0; i<count ; i++){
            for(int j=0; j<4; j++){
                int nx = set[i]/M + dx[j];
                int ny = set[i]%M + dy[j];
                if(nx<0||nx>=N||ny<0||ny>=M||visited[nx][ny]) continue;
                visited[nx][ny] = true;
                int[] temp = set.clone();
                temp[count] = nx*M + ny;
                dfs(count+1, sum+map[nx][ny], temp);
                visited[nx][ny] = false;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] in = Arrays.stream(br.readLine().split(" "))
            .mapToInt(s -> Integer.parseInt(s)).toArray();
        
        N = in[0];
        M = in[1];

        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i=0; i<N; i++){
            int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(s -> Integer.parseInt(s)).toArray();
            for(int j=0; j<M; j++){
                map[i][j] = line[j];
            }
        }

        int[] arr = new int[4];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                arr[0] = i*M + j;
                dfs(1, map[i][j], arr.clone());
                visited[i][j] = false;
            }
        }

        System.out.print(answer);
    }
}