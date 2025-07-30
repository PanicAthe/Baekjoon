
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (isEven(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    //n의 약수의 개수가 짝수인지
    public boolean isEven(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count % 2 == 0;
    }
}