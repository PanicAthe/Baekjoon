import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" "))
            .mapToInt(str -> Integer.parseInt(str))
            .toArray();
        // 수빈이 위치
        int N = temp[0];
        // 동생 위치
        int K = temp[1];

        int[] memo = new int[100001];
        Arrays.fill(memo, -1);

        // 수빈 위치 표시
        memo[N] = 0;
        Deque<Integer> que = new LinkedList<>();
        que.offer(N);

        while(!que.isEmpty()){
            int x = que.poll();

            if(x+1<100001 && memo[x+1]==-1){
                memo[x+1] = memo[x]+1;
                que.offer(x+1);
            }

            if(x-1>=0 && memo[x-1]==-1){
                memo[x-1] = memo[x]+1;
                que.offer(x-1);
            }

            if(x*2<100001 && memo[x*2]==-1){
                memo[x*2] = memo[x]+1;
                que.offer(x*2);
            }

            if(memo[K]!=-1){
                System.out.print(memo[K]);
                return;
            }
        }

    }

}