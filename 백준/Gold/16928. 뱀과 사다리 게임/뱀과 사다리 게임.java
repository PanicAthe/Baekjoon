import java.util.*;
import java.io.*;

class Main {

    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {

        // 도착한 칸이 사다리면 사다리를 타고 큰 칸로 이동
        // 뱀이 있는 칸이면 뱀을 따라서 작은 칸로 이동
        // 1번칸에서 100번 칸에 도착하게하는 주사위 굴리는 최소 횟수 찾기
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 사다리의 수
        int M = Integer.parseInt(st.nextToken());  // 뱀의 수

        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }

        System.out.println(bfs());
    }

    static int bfs(){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});
        visited[1] = true;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if(pos == 100) return cnt;

            for(int dice=1; dice<=6; dice++){

                int next = pos + dice;

                if(next > 100) continue;

                if(board[next] != 0){
                    next = board[next];
                }

                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, cnt+1});
                }
            }
        }

        return -1;
    }
}