class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(long i=0; i<=d;i+=k){
            answer += (long)Math.sqrt((long)d*d-(long)i*i)/k + 1;
        }
        return answer;
    }
}