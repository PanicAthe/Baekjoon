import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] globalBoard;
    static int N, M;
    
    public int dfs(int curX, int curY, int opX, int opY){
        
        // 내가 있던 곳이 사라져 버림
        if(globalBoard[curX][curY] == 0){
            return 0;
        }
        
        int result = 0;
        for(int i=0; i<4; i++){
            int x = curX + dx[i];
            int y = curY + dy[i];
            
            // 이동할 수 없음
            if(x<0 || x>=N || y<0 || y>=M || globalBoard[x][y]==0) continue;
           
            //이동하며 서 있던 발판 없애기
            globalBoard[curX][curY] = 0; 
            int temp = dfs(opX, opY, x, y) + 1;
            globalBoard[curX][curY] = 1; 
            
            // 최상의 선택 업데이트하기
            // 이동했을 때 결과가 짝수로 돌아오면 내 패배 (내턴1+상대턴1->내턴에서 끝)
            if(temp%2==0){
                if(result%2==0){
                    result = Math.max(result, temp);
                }
            }else{
                if(result%2==0){
                    result = temp;
                }else{
                    result = Math.min(result, temp);
                }
            }
        }
        
        return result;
        
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        
        globalBoard = board;
        N = board.length;
        M = board[0].length;
        int answer = dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
        return answer;
    }
}