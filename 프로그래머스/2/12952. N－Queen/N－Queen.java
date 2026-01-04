import java.util.*;

class Solution {
    int answer = 0;
    int N;
    boolean[] col;
    boolean[] diagonal1;
    boolean[] diagonal2;
    
    public void dfs(int row){
        if(row == N){
            answer++;
            return;
        }

        for(int i=0; i<N; i++){
            if(col[i] || diagonal1[row+i] || diagonal2[row-i+N-1]) continue;
            col[i] = true;
            diagonal1[row+i] = true;
            diagonal2[row-i+N-1] = true;
            dfs(row+1);
            col[i] = false;
            diagonal1[row+i] = false;
            diagonal2[row-i+N-1] = false;
        }
    }
    
    public int solution(int n) {
        N = n;
        col = new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2]; 
        
        dfs(0);
        return answer;
    }
}
