class Solution {
    public int solution(String s) {
        int answer = 0;

        while(!s.isEmpty()){
            int count = 0;
            char firstChar = s.charAt(0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == firstChar) {
                    count++;
                } else {
                    count--;
                }

                if (count == 0) {
                    answer++;
                    s = s.substring(i + 1);
                    break;
                }
            }

            if (count != 0) {
                answer++;
                break;
            }
        }

        return answer;
    }
}