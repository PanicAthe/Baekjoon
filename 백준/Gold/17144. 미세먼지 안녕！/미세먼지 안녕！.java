import java.util.*;
import java.io.*;


class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    // A_T: 공기청정기의 상단 index
    // A_B: 공기청정기의 하단 index
    static int R,C,T;
    static int A_T = -1, A_B = -1;
    static int[][] map;

    static void dust(){

        int[][] add = new int[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                // 현재 위치에 먼지가 없으면 패스
                if(map[i][j]<1) continue;
                
                // 확산된 먼지 카운트
                int count = 0;
                for(int k=0; k<4; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    // 공기청정기 칸이나 범위를 넘어서는 곳에는 확산 x
                    if(x<0||x>=R||y<0||y>=C||map[x][y]==-1) continue;
                    count++;
                    // 미세먼지 양은 a/5로 확산
                    add[x][y] += map[i][j]/5;
                }
                // 원본 미세먼지 양은 a-a/5*(확산 개수)
                add[i][j] -= map[i][j]/5*count;
            }
        }

        // 원본에 업데이트
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] += add[i][j];
            }
        }
    }

    static void air(){
                
        // 공기청정기는 항상 0번 열에 설치, 크기는 두 행 차지
        // 바람이 불면 미세먼지는 바람의 방향대로 한 칸 씩 이동
        
        // 공기청정기 상단 바람은 반시계 방향으로 순환 
        int pre = map[A_T][1];
        map[A_T][1] = 0;
        // 공기청정기 상단 > 방향
        for(int i=2; i<C; i++){
            int temp = map[A_T][i];
            map[A_T][i] = pre;
            pre = temp;
        }
        // 공기청정기 상단 ^ 방향
        for(int i=A_T-1; i>=0; i--){
            int temp = map[i][C-1];
            map[i][C-1] = pre;
            pre = temp;
        }
        // 공기청정기 상단 < 방향
        for(int i=C-2; i>=0; i--){
            int temp = map[0][i];
            map[0][i] = pre;
            pre = temp;
        }
        // 공기청정기 상단 v 방향
        for(int i=1; i<A_T; i++){
            int temp = map[i][0];
            map[i][0] = pre;
            pre = temp;
        }
        
        // 공기청정기 하단 바람은 시계 방향
        pre = map[A_B][1];
        map[A_B][1] = 0;
        // 공기청정기 하단 > 방향
        for(int i=2; i<C; i++){
            int temp = map[A_B][i];
            map[A_B][i] = pre;
            pre = temp;
        }

        // 공기청정기 하단 v 방향
        for(int i=A_B+1; i<R; i++){
            int temp = map[i][C-1];
            map[i][C-1] = pre;
            pre = temp;
        }

        // 공기청정기 하단 < 방향
        for(int i=C-2; i>=0; i--){
            int temp = map[R-1][i];
            map[R-1][i] = pre;
            pre = temp;
        }

        // 공기청정기 하단 ^ 방향
        for(int i=R-2; i>A_B; i--){
            int temp = map[i][0];
            map[i][0] = pre;
            pre = temp;
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1){
                    if(A_T==-1) A_T = i;
                    else A_B = i;
                }
            }
        }

        // T초 동안
        while(T-->0){
            
            // 미세먼지 확산
            dust();

            // 공기청정기 작동
            air();
        }

        // 모든 미세먼지 양
        int result = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>0) result += map[i][j];
            }
        }

        System.out.print(result);
    }

}