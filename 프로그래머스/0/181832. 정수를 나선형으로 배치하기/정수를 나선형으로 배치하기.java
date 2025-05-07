class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int curX = 0, curY = 0, dr = 0;

        for (int i = 1; i <= n * n; i++) {
            answer[curX][curY] = i;
            int tempX = curX + dx[dr];
            int tempY = curY + dy[dr];
            if (tempX < 0 || tempY < 0
                    || tempX >= n || tempY >= n || answer[tempX][tempY] != 0) {
                dr = (dr + 1) % 4;
                tempX = curX + dx[dr];
                tempY = curY + dy[dr];
            }

            curX = tempX;
            curY = tempY;
        }

        return answer;
    }
}
