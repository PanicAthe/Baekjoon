import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 각 전선을 돌며
        for(int i=0; i<wires.length; i++){
            
            // Integer을 담는 List을 담는 배열
            List<Integer>[] graph = new ArrayList[n+1];
            
            // 각 송전탑 마다 인접한 송전탑 번호를 담을 arrayList 할당
            for(int j=1; j<=n; j++){
                graph[j] = new ArrayList<>();
            }
            
            for(int j=0; j<wires.length; j++){
                // i번째 전선이 끊어졌다고 가정하기 위해
                if(i==j) continue;
                
                // 서로의 송전탑 리스트에 추가
                int top1 = wires[j][0];
                int top2 = wires[j][1];
                graph[top1].add(top2);
                graph[top2].add(top1);
            }
            
            // 끊어진 전선의 한쪽 송전탑
            int start = wires[i][0];
            // 그 송전탑을 포함한 모든 연결된 송전탑 개수 구하기
            int size = bfs(start, graph, n);
            // 송전탑 개수의 차이 업데이트
            answer = Math.min(answer, Math.abs(size-(n-size)));
        }
        return answer;
    }
    
    public int bfs(int start, List<Integer>[] graph, int n){
        int count = 0;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> que = new LinkedList<>();
        
        visited[start] = true;
        que.add(start);
        
        while(!que.isEmpty()){
            int cur = que.poll();
            count++;
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    que.add(next);
                }
            }
        }     
        return count;      
    }
}