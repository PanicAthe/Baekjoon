import java.util.*;
import java.io.*;

class Main {

    // 이동 방향 (문제에 제시된 1~8 순서 반영: ↑, ↖, ←, ↙, ↓, ↘, →, ↗)
    static int[] dx = new int[]{ -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{ 0, -1, -1, -1, 0, 1, 1, 1};

    static int result = Integer.MIN_VALUE;

    public static void dfs(int sum, int sharkDirection, int sharkX, int sharkY, int[][] map, int[] direction, HashMap<Integer, int[]> pos){
        
        result = Math.max(result, sum);

        int[][] mapCopy = new int[4][4];
        for(int i=0; i<4; i++) mapCopy[i] = map[i].clone();
        int[] dirCopy = direction.clone();
        HashMap<Integer, int[]> posCopy = new HashMap<>();
        for(Integer key : pos.keySet()) posCopy.put(key, pos.get(key).clone());

        // 모든 물고기 이동
        for(int i=1; i<=16; i++){
            if(!posCopy.containsKey(i)) continue; // 물고기가 존재할 때만 이동
            
            int[] temp = posCopy.get(i);
            int curX = temp[0];
            int curY = temp[1];
            int curDirection = dirCopy[i]; // 현재 물고기 방향
            
            int nextDirection = curDirection;
            for(int d=0; d<8; d++){
                nextDirection = (curDirection + d) % 8;
                int x = curX + dx[nextDirection];
                int y = curY + dy[nextDirection];
                
                // 이동 방향으로 이동 가능한지 확인
                if(x>=0 && x<4 && y>=0 && y<4 && !(x==sharkX && y==sharkY)){
                    dirCopy[i] = nextDirection; // 바뀐 방향 저장
                    
                    // 빈 칸이 아니라면 물고기 위치 서로 교체
                    if(mapCopy[x][y] != 0){
                        posCopy.put(mapCopy[x][y], new int[]{curX, curY});
                    }
                    mapCopy[curX][curY] = mapCopy[x][y];
                    mapCopy[x][y] = i;
                    posCopy.put(i, new int[]{x, y});
                    
                    // 이동하면 for문 탈출
                    break;
                }               
            }
        }
        
        // 상어 이동 방향 쪽의 위치
        int sharkCurX = sharkX + dx[sharkDirection];
        int sharkCurY = sharkY + dy[sharkDirection];
        
        // 상어가 이동가능한 방향까지 계속 지나감
        while(sharkCurX>=0 && sharkCurX<4 && sharkCurY>=0 && sharkCurY<4){
            
            // 물고기가 있는 칸일 때만 먹을 수 있음
            if(mapCopy[sharkCurX][sharkCurY] != 0){
                // 현재 위치의 물고기를 먹는다고 가정
                int eatenFish = mapCopy[sharkCurX][sharkCurY];
                int nextSharkDir = dirCopy[eatenFish]; // 먹은 물고기의 방향을 가짐

                int tempFish = mapCopy[sharkCurX][sharkCurY];
                mapCopy[sharkCurX][sharkCurY] = 0; // 물고기 먹음 처리
                posCopy.remove(eatenFish);

                dfs(sum + eatenFish, nextSharkDir, sharkCurX, sharkCurY, mapCopy, dirCopy, posCopy);

                // 먹은 물고기 다시 복구 (백트래킹)
                mapCopy[sharkCurX][sharkCurY] = tempFish;
                posCopy.put(eatenFish, new int[]{sharkCurX, sharkCurY});
            }

            // 다음 상어가 이동할 위치 업데이트 (직진)
            sharkCurX += dx[sharkDirection];
            sharkCurY += dy[sharkDirection];
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][4];
        int[] direction = new int[17];
        HashMap<Integer, int[]> pos = new HashMap<>();

        for(int i=0; i<4; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<4; j++){
                int fishNum = Integer.parseInt(temp[j*2]);
                int dir = Integer.parseInt(temp[j*2 + 1]) - 1;
                map[i][j] = fishNum;
                direction[fishNum] = dir;
                pos.put(fishNum, new int[]{i, j});
            }
        }

        // (0, 0) 위치의 물고기 부터 잡아 먹음
        int firstMeal = map[0][0];
        int firstDir = direction[firstMeal];
        map[0][0] = 0; // 상어가 먹은 자리는 0으로 표시
        pos.remove(firstMeal);

        // 현재 점수와 상어 방향과 위치 넘겨주기
        dfs(firstMeal, firstDir, 0, 0, map, direction, pos);

        // 상어가 먹을 수 있는 물고기 번호의 합의 최댓값을 출력
        System.out.print(result);
    }
}