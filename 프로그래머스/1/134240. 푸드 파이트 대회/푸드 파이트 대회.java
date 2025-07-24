class Solution {
    public String solution(int[] food) {
        String answer = "0";

        for(int i=food.length-1; i>=0; i--) {
            int count = food[i] / 2;
            for(int j=0; j<count; j++) {
                answer += i;
                answer = i + answer; 
            }
        }
        return answer;
    }
}