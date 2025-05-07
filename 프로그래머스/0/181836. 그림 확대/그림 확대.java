class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        for (int i = 0; i < answer.length; i++) {
            String temp = "";
            for (int j = 0; j < picture[i/k].length()*k; j++) {
                int target = j/k;
                temp += picture[i/k].charAt(target);
            }
            answer[i] = temp;
        }
        return answer;
    }
}