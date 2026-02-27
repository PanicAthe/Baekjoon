import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());

        // 기본이 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙의 경우
        //new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(minHeap.isEmpty()){
                    sb.append(0+"\n");
                }else{
                    sb.append(minHeap.poll()+"\n");
                }
            }else{
                minHeap.add(x);
            }
        }
        System.out.print(sb.toString());
        
    }

}