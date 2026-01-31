import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        // 선이 3개 그어지는 순간 빙고.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, int[]> map = new HashMap<>();

        for(int i=0; i<5; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                int n = Integer.parseInt(s[j]);
                map.put(n, new int[]{i, j});
            }
        }

        boolean[][] board = new boolean[5][5];

        int count = 0;
        for(int i=0; i<5; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                // 빙고 체크
                int[] pos = map.get(Integer.parseInt(s[j]));
                int x = pos[0];
                int y = pos[1];
                board[x][y] = true;

                //행 체크
                boolean check = true;
                for(int k=0; k<5; k++){
                    if(!board[x][k]){
                        check = false;
                        break;
                    }
                } 
                if(check) count++;

                //열 체크
                check = true;
                for(int k=0; k<5; k++){
                    if(!board[k][y]){
                        check = false;
                        break;
                    }
                } 
                if(check) count++;

                //대각선 체크
                if(x+y==4){
                    check = true;
                    for(int k=0; k<5; k++){
                        if(!board[k][4-k]){
                            check = false;
                            break;
                        }
                    }
                    if(check) count++;
                } 
                
                if(x==y){
                    check = true;
                    for(int k=0; k<5; k++){
                        if(!board[k][k]){
                            check = false;
                            break;
                        }
                    }
                    if(check) count++;
                } 

                if(count>=3){
                    System.out.println(i*5+j+1);
                    return;
                }
            }
        }
        
    }
}