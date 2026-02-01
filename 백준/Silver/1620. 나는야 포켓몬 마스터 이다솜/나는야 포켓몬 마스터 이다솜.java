import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도감의 포켓몬 개수 N, 문제 개수 m
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        HashMap<String, Integer> setName = new HashMap<>();
        HashMap<Integer, String> setNum = new HashMap<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            setName.put(s, i+1);
            setNum.put(i+1, s);
        }

        for(int i=0; i<M; i++){
            String s = br.readLine();
            // 숫자가 들어옴
            if(s.charAt(0)<='9' && s.charAt(0)>='1'){
                System.out.println(setNum.get(Integer.parseInt(s)));
            }else{
                System.out.println(setName.get(s));
            }
        }
        
    }
}