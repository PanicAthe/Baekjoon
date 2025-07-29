class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < sizes.length; i++) {
            maxWidth = Math.max(maxWidth, Math.max(sizes[i][0], sizes[i][1]));
            maxHeight = Math.max(maxHeight, Math.min(sizes[i][0], sizes[i][1]));
        }

        return maxWidth * maxHeight;
    }
}
