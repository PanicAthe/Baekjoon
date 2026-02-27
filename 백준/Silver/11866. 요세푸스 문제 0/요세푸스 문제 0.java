import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]) - 1;

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        LinkedList<Integer> list = new LinkedList<>();
        boolean start = true;
        for(int i=1; i<=N; i++) list.add(i);

        int index = 0;
        while(list.size()!=0){
            index += K ;
            index %= list.size();
            if(start){
                sb.append(list.get(index));
                start = false;
            }else{
                sb.append(", "+list.get(index));
            }
            list.remove(index);
        }
        sb.append(">");
        System.out.print(sb.toString());
    }


}