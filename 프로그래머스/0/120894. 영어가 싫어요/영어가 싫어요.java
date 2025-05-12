class Solution {
    public long solution(String numbers) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        long answer = 0;
        for (int i = 0; i < numbers.length(); ) {
            for (int j = 0; j < nums.length && i < numbers.length(); j++) {
                if (numbers.substring(i, Math.min(i + nums[j].length(), numbers.length())).equals(nums[j])) {
                    answer *= 10;
                    answer += j;
                    i += nums[j].length();
                    break;
                }
            }
        }
        return answer;
    }
}