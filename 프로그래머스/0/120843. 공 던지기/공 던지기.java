class Solution {
    public int solution(int[] numbers, int k) {
        int cur = 0;
        for(int i=1; i<k; i++){
            cur = (cur+2)%numbers.length;
        }
        return cur+1;
    }
}