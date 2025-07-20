class Solution {
    public int solution(int n, int m, int[] section) {

        int cur = section[0];
        int count = 1; //색칠 횟수

        for(int i=1; i<section.length; i++) {
            if(section[i]-cur >= m) {
                cur = section[i];
                count ++;
            }
        }
        return count;
    }
}