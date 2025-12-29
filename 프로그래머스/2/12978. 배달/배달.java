import java.util.*;

class Solution {

    // 1. 노드 정의 (도착지, 비용)
    class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용이 작은 것이 우선순위가 높음
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 2. 인접 리스트 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 3. 그래프 연결 정보 저장 (양방향)
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 4. 최단 거리(시간)를 저장할 배열 초기화
        // dist[i]는 1번 마을에서 i번 마을까지 가는 '최소 시간'
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 처음엔 모두 무한대로 초기화
        dist[1] = 0; // 시작점(1번)의 시간은 0

        // 5. 다익스트라 알고리즘 시작 (PriorityQueue 사용)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0)); // 시작점 넣기

        while (!pq.isEmpty()) {
            Node current = pq.poll(); // 가장 비용이 적은 노드 꺼내기 

            // 현재 꺼낸 경로의 비용이 이미 기록된 최소 비용보다 크다면 계산할 필요 없음
            // (이미 더 빠른 길을 찾았다는 뜻)
            if (current.cost > dist[current.idx]) continue;

            // 현재 위치와 연결된 인접 마을들 확인
            for (Node next : graph.get(current.idx)) {
                // '현재까지 온 비용 + 다음 마을로 가는 비용'이 '기존에 알고 있던 다음 마을 도착 비용'보다 싸다면 갱신
                if (dist[next.idx] > current.cost + next.cost) {
                    dist[next.idx] = current.cost + next.cost;
                    // 갱신된 정보를 큐에 넣어줌 (새로운 최단 경로 후보)
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        // 6. K시간 이하로 배달 가능한 마을 개수 세기
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}