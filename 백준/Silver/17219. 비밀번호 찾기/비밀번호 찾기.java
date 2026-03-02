import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = Arrays.stream(br.readLine().split(" "))
            .mapToInt(s->Integer.parseInt(s)).toArray();

        int N = temp[0];
        int M = temp[1];

        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String[] set = br.readLine().split(" ");
            map.put(set[0], set[1]);
        }

        for(int i=0; i<M; i++){
            System.out.println(map.get(br.readLine()));
        }
        
    }
}