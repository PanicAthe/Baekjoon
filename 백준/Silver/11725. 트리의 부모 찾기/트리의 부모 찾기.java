import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static ArrayList<Integer>[] graph;
    static int[] parent;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        parent = new int[N+1];
        // 루트 노드 표시
        parent[1] = -1;
        
        for(int i=0; i<N-1; i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        // 루트부터 자식 노드들에게 부모임을 알려주기
        bfs(1);

        for(int i=2; i<=N; i++) System.out.println(parent[i]);
    }

    static void bfs(int start){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        
        while(!que.isEmpty()){
            int cur = que.poll();
            // 자식 노드들 부모 표시
            for(int child : graph[cur]){
                if(parent[child]==0){
                    parent[child] = cur;
                    que.add(child);
                }
            }
        }
    }
}