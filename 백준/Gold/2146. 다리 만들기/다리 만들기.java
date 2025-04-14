import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int map[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static boolean[][] visit;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visit = new boolean[n][n];

        int curIsland = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    if (!visit[i][j]) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        visit[i][j] = true;
                        map[i][j] = curIsland;
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != 0 && !visit[nx][ny]) {
                                    queue.add(new int[]{nx, ny});
                                    map[nx][ny] = curIsland;
                                    visit[nx][ny] = true;
                                }
                            }
                        }
                        curIsland++;
                    }
                }
            }
        }

        visit = new boolean[n][n];

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]!=0){
                    for(int k = 0; k < 4; k++){ //주위에 바다가 있는지 검사
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==0){
                            //주위에 바다가 있다면 다리 설치 시도
                            minDistance = Math.min(minDistance, distance(i, j));
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(minDistance);
        sc.close();

    }

    static int distance(int x, int y){
        boolean[][] visited = new boolean[n][n];
        int[][] temp = new int[n][n];
        int curIsland = map[x][y];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int k = 0; k<4; k++){
                int nx = cur[0]+dx[k];
                int ny = cur[1]+dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]!=curIsland && !visited[nx][ny]){
                    if(map[nx][ny]!=0){
                        return temp[cur[0]][cur[1]];
                    }
                    queue.add(new int[]{nx, ny});
                    temp[nx][ny] = temp[cur[0]][cur[1]]+1;
                    visited[nx][ny] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}
