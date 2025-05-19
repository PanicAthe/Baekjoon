class Solution {
    public int solution(int n) {
        int answer = 1; 
        long f = 1;
        while(f<=n){
            f*=answer;
            answer++;
        }
        return answer-2;
    }
}