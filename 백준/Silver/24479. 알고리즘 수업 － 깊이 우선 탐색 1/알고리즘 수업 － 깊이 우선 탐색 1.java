import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static ArrayList<Integer>[] graph;
    static int[] order;
    static int count = 1;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        // 정점의 수
        int N = Integer.parseInt(str[0]);
        // 간선의 수
        int M = Integer.parseInt(str[1]);
        // 시작 정점
        int R = Integer.parseInt(str[2]);

        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        // 인접 정점을 오름차순으로 방문하기 위함
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }
        
        order = new int[N+1];
        dfs(R);
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int start){
        order[start] = count++;
        for(int node : graph[start]){
            if(order[node]==0){
                dfs(node);
            }
        }
        
    }

}