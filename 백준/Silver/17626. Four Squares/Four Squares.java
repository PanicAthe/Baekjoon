import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            dp[i] = i; // 제곱수의 합을 1*1로만 채움

            // i의 제곱근을 모두 돌면서
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        
        System.out.print(dp[n]);
    }
}