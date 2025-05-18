class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public int[] solution(String[] keyinput, int[] board) {
        int pox = 0;
        int poy = 0;
        for(int i=0; i<keyinput.length;i++){
            int nx = pox;
            int ny = poy;
            if(keyinput[i].equals("left")){
                nx += dx[2];
                ny += dy[2];
            }else if(keyinput[i].equals("up")){
                nx += dx[0];
                ny += dy[0];
            }else if(keyinput[i].equals("down")){
                nx += dx[1];
                ny += dy[1];
            }else{
                nx += dx[3];
                ny += dy[3];
            }
            if(nx<-board[0]/2||ny<-board[1]/2||nx>board[0]/2||ny>board[1]/2) continue;
            pox = nx;
            poy = ny;
        }
        return new int[]{pox, poy};
    }
}