import java.util.*;

class Solution {
    
    boolean[] visited;
    int[][] globalComputers;
    
    public void dfs(int index){
        for(int i=0; i<globalComputers.length; i++){
            if(!visited[i]&&globalComputers[index][i]==1){
                visited[i] = true;
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        globalComputers = computers;
        visited = new boolean[computers.length];
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}