class Solution {
    static int[][] globalDungeons;
    static int answer = 0;
    
    static void dfs(int k, boolean[] visited, int count){
        answer = Math.max(answer, count);
        
        if(count==globalDungeons.length){
            return;
        }else{
            for(int i=0; i<globalDungeons.length; i++){
                if(!visited[i] && globalDungeons[i][0] <= k){
                    visited[i] = true;
                    dfs(k-globalDungeons[i][1], visited, count+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        globalDungeons = dungeons;
        dfs(k, new boolean[dungeons.length], 0);
        return answer;
    }
}