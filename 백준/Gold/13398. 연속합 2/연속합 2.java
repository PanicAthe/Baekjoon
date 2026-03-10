import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        // 수열 중에서 연속된 몇 개의 수를 선택
        // 수열합 중 가장 큰 합을 구하기
        // 수는 한개 이상 선택
        // 또, 수열에서 수를 하나 제거해도 됨

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());


        int result = nums[0];
        
        // dp[i] : 0~i번째 숫자까지 수열합 중 최대 값(빠지는 수 없음)
        int[] dp = new int[n];
        // dp1[i] : 0~i번째 숫자까지 수열합 중 최대 값(빠지는 수 1개)
        int[] dp1 = new int[n];

        dp[0] = nums[0];
        // 수는 한개 이상 선택해야 함
        dp1[0] = nums[0];
    
        for(int i=1; i<n; i++){
            // (직전까지의 수열 합(dp) + 현재 수)와 현재 수를 비교
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);

            // (직전까지의 수열합(dp1) + 현재 수)와 직전 수열합(dp)을 비교
            // 직전 수열합(dp)를 사용하는 이유는 현재 i번째 수가 빠진다고 가정하기 때문
            dp1[i] = Math.max(dp1[i-1]+nums[i], dp[i-1]);
            
            result = Math.max(result, Math.max(dp[i], dp1[i]));
        }
        
        System.out.print(result);
    }
}