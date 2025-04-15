class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long l = d;
        for(long i=0; i<=l;i+=k){
            answer += (long)Math.sqrt((long)l*l-(long)i*i)/k + 1;
        }
        return answer;
    }
}