import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static int answer = Integer.MAX_VALUE;
    static int N;
    
    public int solution(int n, int[][] wires) {
        N = n;

        // 그래프 초기화
        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();        
        for(int i=0; i<wires.length; i++){
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        

        for(int i=0; i<wires.length; i++){
            
            // 한 간선을 제거한다고 가정.. 반드시 타입 캐스팅
            //ArrayList에서 remove 메서드는 두 가지로 오버로딩되어 있습니다.
            //remove(int index) : 해당 인덱스에 있는 값을 지웁니다.
            //remove(Object o) : 해당 객체를 찾아서 지웁니다.
            
            graph[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            graph[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            
            // 간선이 제거된 각 송전탑 dfs
            int result = dfs(wires[i][0]);
            
            answer = Math.min(answer, Math.abs((N-result)-result));
            
            // 제거된 간선 다시 추가
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        return answer;
    }
    
    static int dfs(int start){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        
        int count = 1;
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            for(int node : graph[cur]){
                if(!visited[node]){
                    count++;
                    visited[node] = true;;
                    stack.push(node);
                }
            }
        }
        return count;
    }
}