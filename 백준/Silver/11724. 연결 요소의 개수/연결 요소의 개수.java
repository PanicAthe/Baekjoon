import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(str->Integer.parseInt(str)).toArray();
        // 정점의 수
        int N = temp[0];
        // 간선의 수
        int M = temp[1];

        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            int[] node = Arrays.stream(br.readLine().split(" "))
                .mapToInt(str->Integer.parseInt(str)).toArray();
            graph[node[0]].add(node[1]);
            graph[node[1]].add(node[0]);
        }

        int answer = 0;
        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        System.out.print(answer);
        
    }

    static void dfs(int start){
        Deque<Integer> stack = new LinkedList<>();
        visited[start] = true;
        stack.push(start);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            for(int node : graph[cur]){
                if(!visited[node]){
                    visited[node] = true;
                    stack.push(node);
                }
            }
        }
    }
}