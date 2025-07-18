import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // 문자별 최소 누르는 횟수를 저장할 맵
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c, j + 1);
                } else {
                    int prev = map.get(c);
                    if (prev > j + 1) {
                        map.put(c, j + 1);
                    }
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (!map.containsKey(c)) {
                    sum = -1;
                    break;
                } else {
                    sum += map.get(c);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
