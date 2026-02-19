import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // i 개의 돌이 주어졌을 때, 시작하는 사람이 이길지 체크
        boolean[] dp = new boolean[N+1];

        for(int i=1; i<=N; i++){
            boolean check = false;
            
            // i-1 이 false라면 돌 1개를 가져가고 내가 이길 수 있음 
            if(!dp[i-1]){
                check = true;
            }

            // i-3 이 false라면 돌 3개를 가져가고 내가 이길 수 있음 
            if(i>=3 && !dp[i-3]){
                check = true;
            }

            // i-4 이 false라면 돌 4개를 가져가고 내가 이길 수 있음
            if(i>=4 && !dp[i-4]){
                check = true;
            }

            dp[i] = check;
        }

        if(dp[N]){
            System.out.print("SK");
        }else{
            System.out.print("CY");
        }
    }
}