import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 모든 전선 정보를 돌며
        for(int i=0; i<wires.length; i++){
            
            //각 송전탑 리스트 
            List<Integer>[] graph = new ArrayList[n + 1];
            
            //각 송전탑 인접 리스트 만들기
            //이걸 안하면 graph[1..n] 전부 null
            for(int j=1; j<n+1; j++) graph[j] = new ArrayList<>();      
            
            // 전선 정보를 보고 각 송전탑에 연결 된 송전탑 업데이트하기
            for(int j=0; j<wires.length; j++){
                
                // i번 전선을 끊었을 경우 반영을 위해
                if(i==j) continue;
                
                // 각 송전탑에 서로 업데이트
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }

            // 끊긴 전선의 한쪽 송전탑을 bfs로 탐색하여 연결된 송전탑 개수 구하기
            int start = wires[i][0];
            int size = bfs(start, graph, n);
            
            answer = Math.min(answer, Math.abs(size-(n-size)));
        }
        
        return answer;
    }
    
    public int bfs(int start, List<Integer>[] graph, int n){
        boolean[] visited = new boolean[n+1];
        int size = 0;
        Queue<Integer> que = new LinkedList<>();
        
        // 시작 송전탑 큐에 넣고 방문 체크 하기
        que.offer(start);
        visited[start] = true;
        
        while(!que.isEmpty()){
            // 방문(탐색)한 송전탑 수 증가
            int a = que.poll();
            size++;
            
            // 해당 송전탑과 연결된 모든 송전탑을 돌면서
            for(int b : graph[a]){
                // 방문하지 않았던 송전탑이라면
                if(!visited[b]){
                    // 방문 체크하고 큐에 넣기
                    que.offer(b);
                    visited[b] = true;
                }
            }
        }
        return size;  
    }
} 