import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        // house[i][j]: i번 집을 j 색상으로 칠하는 비용
        int[][] house = new int[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j]: i번째 집까지 칠하고 i번째 집은 j 색상일때 최소 비용
        int[][] dp = new int[N][3];
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        for(int i=1; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + house[i][2];
        }

        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.print(result);
    }

}