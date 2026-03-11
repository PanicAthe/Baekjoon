import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node{
        int id;
        int value;

        Node(int id, int value){
            this.id = id;
            this.value = value;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 데이터의 수
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++){
            
            // 적용할 연산의 개수
            int k = Integer.parseInt(br.readLine());

            // 삭제됐는지 확인
            boolean[] removed = new boolean[k];
            // id 할당을 위한 변수
            int index = 0;
            
            PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));
            PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
            StringTokenizer st;
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                // 큐에 삽입
                if(s.equals("I")){
                    Node input = new Node(index++, n);
                    maxHeap.offer(input);
                    minHeap.offer(input);
                }else{
                    // 최댓값을 삭제
                    if(n==1){
                        // 힙에 값이 있다면
                        if(!maxHeap.isEmpty()){
                            // 힙에 값이 존재하는 동안
                            while(!maxHeap.isEmpty()){
                                Node node = maxHeap.poll();
                                if(!removed[node.id]){
                                    removed[node.id] = true;
                                    break;
                                }
                            }
                        }
                        
                    }else{
                        // 힙에 값이 있다면
                        if(!minHeap.isEmpty()){
                            // 힙에 값이 존재하는 동안
                            while(!minHeap.isEmpty()){
                                Node node = minHeap.poll();
                                if(!removed[node.id]){
                                    removed[node.id] = true;
                                    break;
                                }
                            }
                        }
                    }
                    
                }

            }

            boolean has = false;
                
            // 삭제한 데이터 모두 삭제
            while(!minHeap.isEmpty() && removed[minHeap.peek().id]){
                minHeap.poll();
            }
            while(!maxHeap.isEmpty() && removed[maxHeap.peek().id]){
                maxHeap.poll();
            }
                
            // 힙이 아예 비어 있음
            if(maxHeap.isEmpty()){
                System.out.println("EMPTY");
                continue;
            }
            Node max = maxHeap.poll();

            int min = max.value;
            if(!minHeap.isEmpty()){
                min = minHeap.poll().value;
            }

            System.out.println(max.value+" "+min);
            
        }      
        
    }
}