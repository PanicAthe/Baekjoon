class Solution {
    public int solution(int n, int k) {
        k = Math.max(k-n/10,0);
        return 12000*n+k*2000;
    }
}