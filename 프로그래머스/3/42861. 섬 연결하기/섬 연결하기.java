import java.util.*;

class Solution {
    
    static int[] parent;
    
    static int root(int x){
        if(parent[x] == x) return x;
        return parent[x] = root(parent[x]);
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
            // 비용 오름차순
            return this.cost - o.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<costs.length; i++){
            pq.offer(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int x = root(cur.from);
            int y = root(cur.to);
            
            // 서로 이어져 있지 않다면 간선 이어주기
            if(x!=y){
                parent[x] = y;
                answer += cur.cost;
            }
        }
        
        return answer;
    }
}