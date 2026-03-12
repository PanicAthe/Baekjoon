import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)-> {return b-a;});

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(!que.isEmpty()){
                    System.out.println(que.poll());
                }else{
                    System.out.println("0");
                }
            }else{
                que.offer(x);
            }
        }
    }
}