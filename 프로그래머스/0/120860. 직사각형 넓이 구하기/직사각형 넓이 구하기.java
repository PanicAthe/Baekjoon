class Solution {
    public int solution(int[][] dots) {
        int max_x = dots[0][0];
        int min_x = dots[0][0];
        int max_y = dots[0][1];
        int min_y = dots[0][1];
        for(int i=1; i<dots.length; i++){
            max_x = Math.max(max_x, dots[i][0]);
            min_x = Math.min(min_x, dots[i][0]);
            max_y = Math.max(max_y, dots[i][1]);
            min_y = Math.min(min_y, dots[i][1]);
        }
        return (max_x-min_x)*(max_y-min_y);
    }
}