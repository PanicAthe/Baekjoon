class Solution {
    public String solution(String s) {
        String answer = "";
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                answer += (char)('a' + i);
            }
        }
        return answer;
    }
}