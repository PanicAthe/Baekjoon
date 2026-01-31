import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        // 듣도 못한 사람의 수
        int N = Integer.parseInt(str[0]);
        // 보도 못한 사람의 수
        int M = Integer.parseInt(str[1]);

        // 듣도 못한 사람의 수를 저장
        HashSet<String> set = new HashSet<>();
        while(N-->0){
            set.add(br.readLine());
        }
        // 듣보잡 저장할 List
        List<String> result = new ArrayList<>();
        while(M-->0){
            String temp = br.readLine();
            // 보도 못한 사람이 듣도 못한 사람이기도 한지 검사
            if(set.contains(temp)){
                result.add(temp);
            }
        }

        System.out.println(result.size());
        result.sort(null);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
        
    }
}