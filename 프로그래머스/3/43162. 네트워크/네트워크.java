import java.util.*;

class Solution {
    
    static int[] parent;
    
    static int root(int x){
        if(parent[x] == x) return x;
        // 경로 단축
        return parent[x] = root(parent[x]);
    }
    
    public int solution(int n, int[][] computers) {
        
        int answer = n;
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j || computers[i][j]==0) continue;
                int x = root(i);
                int y = root(j);
                
                // 루트가 다르다면 합치기
                if(x!=y){
                    parent[x] = y;
                    answer--;
                }
            }
        }
        
        return answer;
    }
}