import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] num = br.readLine().split(" ");
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(num[i]);
        }

        // 첫번째 연속된 날들의 온도 합
        int result = 0; 
        for(int i=0; i<K; i++){
            result += nums[i];
        }
        
        // 0부터 N-k까지
        // 직전에 계산한 i번째 날 온도를 합산에서 빼고, i+K번째 온도를 더함
        int curSum = result;
        for(int i=0; i<N-K; i++){
            curSum -= nums[i];
            curSum += nums[i+K];
            result = Math.max(result, curSum);
        }

        System.out.print(result);
    }
}