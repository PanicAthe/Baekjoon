import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        // 보드판 초기화
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = temp.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<n-7; i++){
            for(int j=0; j<m-7; j++){
                // 시작점 색상
                char start = board[i][j];
                
                // 시작점 칸의 색칠을 바꾸지 않았을 때,
                int fixCount = 0;
                for(int k=i; k<i+8; k++){
                    for(int l=j; l<j+8; l++){
                        if(k==i && l==j) continue;
                        // 시작 칸과 같은 색상이여야함
                        if((k + l - i - j)%2==0){
                            if(start!=board[k][l]) fixCount++;
                        }else{
                            // 시작칸과 다른 색상이여야함.
                            if(start==board[k][l]) fixCount++;
                        }
                    }
                }

                minCount = Math.min(fixCount, minCount);

                // i, j 칸의 색칠을 바꿀 때
                fixCount = 1;
                for(int k=i; k<i+8; k++){
                    for(int l=j; l<j+8; l++){
                        if(k==i && l==j) continue;
                        // 시작 칸의 색칠을 바꾼다고 가정,
                        // 본래 색상과는 다른 색상이여야함
                        if((k + l - i - j)%2==0){
                            if(start==board[k][l]) fixCount++;
                        }else{
                            // 시작칸과 다른 색상이여야함.
                            if(start!=board[k][l]) fixCount++;
                        }
                    }
                }
                minCount = Math.min(fixCount, minCount);
                
            }
        }

        System.out.print(minCount);
        
    }
}