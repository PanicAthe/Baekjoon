class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int pre = 0;
        
        for (int i = 0; i < dartResult.length();) {
            int cur;
            if (i + 1 < dartResult.length() && dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                cur = 10;
                i += 2;
            } else {
                cur = dartResult.charAt(i) - '0';
                i++;
            }
            
            char bonus = dartResult.charAt(i++);
            if (bonus == 'D') cur = cur * cur;
            else if (bonus == 'T') cur = cur * cur * cur;

            // *, #
            if (i < dartResult.length()) {
                if (dartResult.charAt(i) == '*') {
                    cur *= 2;
                    answer += pre;
                    i++;
                } else if (dartResult.charAt(i) == '#') {
                    cur *= -1;
                    i++;
                }
            }
            
            answer += cur;
            pre = cur;
        }
        
        return answer;
    }
}