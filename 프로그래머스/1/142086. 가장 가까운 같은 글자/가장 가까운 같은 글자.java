class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)-'a'] == -1){
                answer[i] = -1;
            }else{
                answer[i] = i-count[s.charAt(i) - 'a'];
            }
            count[s.charAt(i) - 'a'] = i;
        }
        return answer;
    }
}