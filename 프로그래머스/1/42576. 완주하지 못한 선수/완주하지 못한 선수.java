import java.util.Map;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new java.util.HashMap<>();
        for (String p : participant) { 
            // 동명이인이면 카운트 증가
            // 동명이인이 아니면 카운트 1
            map.put(p, map.getOrDefault(p, 0) + 1);
        } 
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                //동명이인까지 모두 완주
                map.remove(c);
            }
        }
        return map.keySet().iterator().next();
    }
}
