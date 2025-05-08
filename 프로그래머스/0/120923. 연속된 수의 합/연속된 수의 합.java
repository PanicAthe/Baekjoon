class Solution {
    public int[] solution(int num, int total) {
        int start = total*2/num+1-num;
        start /= 2;
        int[] result = new int[num];
        for(int i=0; i<num; i++){
            result[i] = start+i;
        }
        return result;
    }
}