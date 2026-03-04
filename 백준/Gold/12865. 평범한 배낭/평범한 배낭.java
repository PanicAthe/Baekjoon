import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        int[] weight = new int[N];
        int[] value = new int[N];

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            weight[i] = Integer.parseInt(parts[0]);
            value[i] = Integer.parseInt(parts[1]);
        }

        // DP: dp[j] = 최대 무게 j까지 담았을 때 가치
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            // 뒤에서부터 처리해야 이전 값을 덮어쓰지 않음
            for (int j = K; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.print(dp[K]);
    }
}