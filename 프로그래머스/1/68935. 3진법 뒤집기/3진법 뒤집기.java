class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        while(n>2){
            temp += n % 3;
            n /= 3;
        }
        temp += n;
        int t = 1;
        for(int i=temp.length()-1; i>=0; i--){
            answer += t*(temp.charAt(i)-'0');
            t*=3;
        }
        return answer;
    }
}