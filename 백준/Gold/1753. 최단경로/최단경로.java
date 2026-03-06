import java.util.*;
import java.io.*;


class Main {

    static class Node implements Comparable<Node>{
        int v, weight;

        Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] dist;

    static void dijkstra(int start){
        PriorityQueue<Node> que = new PriorityQueue<>();

        dist[start] = 0;
        que.add(new Node(start, 0));

        while(!que.isEmpty()){

            // 현재 시작 정점으로부터 거리 가중치가 가장 작은 정점
            Node cur = que.poll();
            int v = cur.v;
            int weight = cur.weight;

            // 이미 짧은 거리라면 패스
            if(dist[v] < weight) continue;

            // 현재 정점에서 갈 수 있는 next 정점 확인
            for(Node next: graph[v]){

                int nextV = next.v;
                // 시작 정점에서 현재 정점을 거쳐 next 정점으로 가는 총 가중치 계산
                int nextWeight = weight + next.weight;

                // 기존에 기록된 최단 거리보다 더 짧은 경로를 찾은 경우에만 갱신
                if(dist[nextV]> nextWeight){
                    dist[nextV] = nextWeight;
                    // 새로운 가중치 정보 큐에 추가
                    que.add(new Node(nextV, nextWeight));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        V = Integer.parseInt(st.nextToken());
        //간선의 개수
        E = Integer.parseInt(st.nextToken());
        // 시작 정점의 번호
        K = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList[V];
        dist = new int[V];
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }


        // 다익스트라
        dijkstra(K);

        // 결과
        for(int i=0;i<V;i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

}