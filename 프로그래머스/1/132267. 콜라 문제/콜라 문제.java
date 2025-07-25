class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int x; // 받을 콜라
        while(n>=a){
            x = n/a*b;
            n = n%a;
            n += x;
            answer += x;
        }
        return answer;
    }
}