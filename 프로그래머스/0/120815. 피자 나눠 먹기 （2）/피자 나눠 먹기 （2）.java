class Solution {
    public int solution(int n) {
        int result = 1;
        while(n*result%6!=0){
            result++;
        }
        return result*n/6;
    }
}