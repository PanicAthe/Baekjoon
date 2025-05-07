import java.util.HashSet;
import java.util.Set;

class Solution {
    static boolean[] visited;
    static String[] strings = {"aya", "ye", "woo", "ma"};
    static Set<String> set = new HashSet<>();
    static void seq(String s, int k){
        if(k<4){
            for(int i=0;i<4;i++){
                if(!visited[i]){
                    visited[i] = true;
                    set.add(s+strings[i]);
                    seq(s+strings[i], k+1);
                    visited[i] = false;
                }
            }
        }
    }
    public int solution(String[] babbling) {
        visited = new boolean[babbling.length];
        seq("",0);
        int result = 0;
        for(int i=0;i<babbling.length;i++){
            if(set.contains(babbling[i])){
                result++;
            }
        }
        return result;
    }
}