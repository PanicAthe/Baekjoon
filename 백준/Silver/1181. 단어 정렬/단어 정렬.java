import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            String s = br.readLine();
            if(!set.contains(s)){
                set.add(s);
                list.add(s);
            }
        }

        list.sort((a, b)->{
            if(a.length()==b.length()){
                for(int i=0; i<a.length(); i++){
                    if(a.charAt(i)==b.charAt(i)){
                        continue;
                    }else{
                        // 길이가 같다면 사전 순
                        return a.charAt(i)-b.charAt(i);
                    }
                }
            }
            // 길이 오름차순
            return a.length()-b.length();
        });
            
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}