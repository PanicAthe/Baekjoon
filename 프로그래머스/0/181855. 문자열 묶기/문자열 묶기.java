import java.util.Arrays;
class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[31];
        for(int i=0; i<strArr.length;i++){
            count[strArr[i].length()]++;
        }
        Arrays.sort(count);
        return count[30];
    }
}