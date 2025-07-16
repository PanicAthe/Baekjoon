class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0; //같은 색으로 색칠된 칸 수
        int[] dh = {0, 1, 0, -1};
        int[] dw = {1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int curH = h + dh[i];
            int curW = w + dw[i];

            if(curH < 0 || curH >= n || curW < 0 || curW >= n) continue; 

            if(board[curH][curW].equals(board[h][w])){ 
                count++;
                board[curH][curW] = "0"; //색칠된 칸은 0으로 변경
            }
        }

        return count;
    }
}