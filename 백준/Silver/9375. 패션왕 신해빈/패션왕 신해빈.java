import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){

            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++){
                String[] str = br.readLine().split(" ");
                map.put(str[1], (map.containsKey(str[1]))? map.get(str[1])+1 : 1);
            }

            int answer = 1;
            for(String s : map.keySet()){
                // 해당 의상 종류에서 하나를 선택하거나 아예 선택하지 않거나
                answer *= (map.get(s)+1);
            }
            
            // 모든 종류를 선택하지 않은 상태 = 알몸 상태는 제외
            System.out.println(answer-1);
        }
        
    }
}