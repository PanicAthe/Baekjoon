import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int j=0;
        for(int i = 0; i < 10; i++) {
            if(j<numbers.length && i==numbers[j]) {
                j++;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}