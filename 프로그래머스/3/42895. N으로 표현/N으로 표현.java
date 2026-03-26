import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        // dp[i] : i번 숫자 N를 포함해서 만들 수 있는 수 집합
        Set<Integer>[] dp = new HashSet[9];
        
        for(int i=1; i<=8; i++){
            dp[i] = new HashSet<>();
            
            // N, NN, NNN
            int n = 0;
            for(int j=0; j<i; j++){
                n = n*10 + N;
            }
            dp[i].add(n);
            
            // j번 숫자 N를 포함해서 만들 수 있는 수의 집합과
            // i-j번 숫자 N를 포함해서 만들 수 있는 수 집합의 조합
            for(int j=1; j<i; j++){
                for(int a: dp[j]){
                    for(int b: dp[i-j]){
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(a*b);
                        if(b!=0) dp[i].add(a/b);
                    }
                }
            }
            
            // i번 숫자를 포함 시 number를 완성한다면
            if(dp[i].contains(number))
                return i;
        }
        
        return -1;
    }
}