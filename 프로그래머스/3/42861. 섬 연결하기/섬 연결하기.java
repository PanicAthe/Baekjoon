import java.util.*;

class Solution {
    
    static int[] parent;
    
    // 본인 루트 찾는 메소드
    static int find(int x){
        if(parent[x] == x) return x;
        // 루트 찾는 경로 압축
        return parent[x] = find(parent[x]);
    }
    
    class Edge implements Comparable<Edge>{
        int from, to, cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        
        // n개의 섬을 잇는 최소 다리 건설 비용 구하기
        
        // costs[i][0] : from
        // costs[i][1] : to
        // costs[i][2] : cost, 다리 건설 비용
        
         // 간선들을 건설 비용 오름차순으로 정리
        ArrayList<Edge> list = new ArrayList<>();
        for(int i=0; i<costs.length; i++){
            list.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        list.sort(null);
        
        // 부모 초기화
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        int answer = 0;
        
        for(Edge edge : list){
            int rootX = find(edge.from);
            int rootY = find(edge.to);
            
            // 루트가 달라 사이클이 생기지 않음
            if(rootX != rootY){
                answer += edge.cost;
                // 다리 연결
                parent[rootX] = rootY;
            }
        }
        
        return answer;
    }
}