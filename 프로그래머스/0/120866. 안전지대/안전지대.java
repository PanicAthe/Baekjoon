class Solution {
    static int[] dx = {0,0,0,-1,-1,-1,1,1,1};
    static int[] dy = {0,-1,1,0,-1,1,0,-1,1};

    public int solution(int[][] board) {
        int answer = 0;
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length;j++){
                boolean safe = true;
                for(int k=0; k<9;k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x<0||y<0||x>=board.length||y>=board.length) continue;
                    if(board[x][y]==1){
                        safe=false;
                        break;
                    }
                }
                if(safe) answer++;
            }
        }
        return answer;
    }
}