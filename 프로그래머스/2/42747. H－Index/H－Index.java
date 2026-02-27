import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            // 현재 위치에서 가능한 최대 h
            int h = n - i;  
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}