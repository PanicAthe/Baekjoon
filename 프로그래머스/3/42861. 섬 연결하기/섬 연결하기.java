import java.util.*;

class Solution {
    
    static int[] parent;
    
    public static int find(int x){
        // x가 루트라면 x 반환
        if(parent[x]==x) return x;
        // x의 루트를 찾아서 값 업데이트 후 반환
        return parent[x] = find(parent[x]);
    }
       
    class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        // 비용 오름차순
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        
        // 루트 초기화
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        ArrayList<Edge> list = new ArrayList<>();
        
        for(int i=0; i<costs.length; i++){
            list.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        Collections.sort(list);
        
        int answer = 0;
        
        // 비용이 작은 순서대로 다리 놓기 (사이클은 제외)
        for(Edge edge : list){
            int rootX = find(edge.from);
            int rootY = find(edge.to);
            
            // 사이클이 생기지 않는 경우
            if(rootX != rootY){
                parent[rootY] = rootX;
                answer += edge.cost;
            }
        }
        
        return answer;
    }
}