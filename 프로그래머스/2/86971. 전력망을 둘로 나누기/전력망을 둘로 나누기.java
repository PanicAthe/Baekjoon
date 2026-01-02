import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
                
        for(int i=0; i<wires.length; i++){
            List<Integer>[] graph = new ArrayList[n + 1];
            for(int j=1; j<n+1; j++) graph[j] = new ArrayList<>();           
            for(int j=0; j<wires.length; j++){
                if(i==j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            int start = wires[i][0];
            int size = dfs(start, graph, n);
            
            answer = Math.min(answer, Math.abs(size-(n-size)));
        }
        
        return answer;
    }
    
    public int dfs(int start, List<Integer>[] graph, int n){
        boolean[] visited = new boolean[n+1];
        int size = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        
        while(!que.isEmpty()){
            int a = que.poll();
            size++;
            for(int b : graph[a]){
                if(!visited[b]){
                    visited[b] = true;
                    que.offer(b);
                }
            }
        }
        return size;
        
    }
} 