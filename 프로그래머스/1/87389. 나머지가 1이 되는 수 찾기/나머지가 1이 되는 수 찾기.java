class Solution {
    public int solution(int n) {
        int minDivisor = getMinDivisor(n-1);
        if(minDivisor == -1) {
            return n-1; // n이 1인 경우
        }
        return minDivisor;
    }

    //1 과 본인을 제외한 제일 작은 약수
    public int getMinDivisor(int n) {
        if (n <= 1) return -1; 
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i; 
            }
        }
        return n; 
    }
}

