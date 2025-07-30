class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCount = 0;
        int matchCount = 0;
        for(int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            } else {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        matchCount++;
                        break;
                    }
                }
            }
        }

        int max = Math.min(7 - (matchCount + zeroCount), 6);
        int min = Math.min(7 - matchCount, 6);
        return new int[]{max, min};

    }
}