import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        Integer[] m = new Integer[score.length];
        for(int i = 0; i < score.length; i++) {
            m[i] = score[i][0]+score[i][1];
        }
        Arrays.sort(m, Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < score.length; i++) {
            if(!map.containsKey(m[i])) {
                map.put(m[i], i+1);
            }
        }

        for(int i = 0; i < score.length; i++) {
            answer[i] = map.get(Integer.valueOf(score[i][0]+score[i][1]));
        }
        return answer;
    }
}