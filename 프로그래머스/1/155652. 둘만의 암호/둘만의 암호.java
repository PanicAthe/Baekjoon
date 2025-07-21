class Solution {
    public String solution(String s, String skip, int index) {
       String answer = "";
        for (char c : s.toCharArray()) {
            int count = 0;
            while (count < index) {
                c++;
                if (c > 'z') c = 'a';
                if (!skip.contains(String.valueOf(c))) {
                    count++;
                }
            }
            answer += c;
        }
        return answer;
    }
}
