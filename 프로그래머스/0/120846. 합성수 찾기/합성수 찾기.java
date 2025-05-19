class Solution {
    public int solution(int n) {
        int[] dp = new int[101];
        for(int i=4; i<=n;i++){
            for(int j=2; j<i; j++){
                if(i%j==0){
                    dp[i] += 1;
                    break;
                }
            }
            dp[i] += dp[i-1];
        }
        return dp[n];
    }
}