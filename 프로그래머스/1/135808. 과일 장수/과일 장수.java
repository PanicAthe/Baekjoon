import java.util.Arrays;

class Solution {

    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int sum = 0;
        for(int i=score.length-1; i>score.length%m;){
            int temp = 0;
            int min = score[i];
            for(int j=0; j<m; j++){
                temp += score[i];
                min = Math.min(min, score[i--]);
            }
            sum+=min*m;
        }
        return sum;
    }


}