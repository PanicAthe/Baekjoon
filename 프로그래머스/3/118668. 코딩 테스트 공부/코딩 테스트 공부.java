import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int a, c, cost;
        Node(int a, int c, int cost) {
            this.a = a;
            this.c = c;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    public int solution(int alp, int cop, int[][] problems) {
        
        int targetA = alp, targetC = cop;
        for (int[] p : problems) {
            targetA = Math.max(targetA, p[0]);
            targetC = Math.max(targetC, p[1]);
        }
        
        int[][] dist = new int[targetA+1][targetC+1];
        for (int i = 0; i <= targetA; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
               
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(alp, cop, 0));
        dist[alp][cop] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.cost > dist[cur.a][cur.c]) continue;
            
            if (cur.a >= targetA && cur.c >= targetC) {
                return cur.cost;
            }
            
            // 부족한 부분 공부
            if (cur.a < targetA && dist[cur.a+1][cur.c] > cur.cost + 1) {
                dist[cur.a+1][cur.c] = cur.cost + 1;
                pq.offer(new Node(cur.a+1, cur.c, cur.cost+1));
            }
            
            if (cur.c < targetC && dist[cur.a][cur.c+1] > cur.cost + 1) {
                dist[cur.a][cur.c+1] = cur.cost + 1;
                pq.offer(new Node(cur.a, cur.c+1, cur.cost+1));
            }
            
            // 문제 풀기
            for (int[] p : problems) {
                if (cur.a >= p[0] && cur.c >= p[1]) {
                    int nextA = Math.min(targetA, cur.a + p[2]);
                    int nextC = Math.min(targetC, cur.c + p[3]);
                    int nextCost = cur.cost + p[4];
                    
                    if (dist[nextA][nextC] > nextCost) {
                        dist[nextA][nextC] = nextCost;
                        pq.offer(new Node(nextA, nextC, nextCost));
                    }
                }
            }
        }
        
        return -1;
    }
}