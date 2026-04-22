import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 이미 본 문자라면 left를 점프
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}