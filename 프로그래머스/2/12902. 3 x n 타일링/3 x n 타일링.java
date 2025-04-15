class Solution {
    public int solution(int n) {
        if (n % 2 != 0) return 0;

        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (dp[i - 2] * 3) % MOD;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] = (dp[i] + dp[j] * 2) % MOD;
            }
        }

        return (int) dp[n];
    }
}
