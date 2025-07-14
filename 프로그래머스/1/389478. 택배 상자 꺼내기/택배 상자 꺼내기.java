class Solution {
    public int solution(int n, int w, int num) {
        if (w == 1) {
            return n - num + 1;
        }

        int answer = 0;
        int row = (num - 1) / w + 1;

        int col;
        if (row % 2 == 1) {
            col = num - w * (row - 1);
        } else {
            col = w * row - num + 1;
        }

        int k = w * 2 - col * 2 + 1;

        while (num <= n) {
            answer++;
            if (row % 2 == 1) {
                num += k;
            } else {
                num += w * 2 - k;
            }
            row++;
        }

        return answer;
    }
}
