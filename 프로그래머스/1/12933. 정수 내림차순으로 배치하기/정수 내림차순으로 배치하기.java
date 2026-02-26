import java.util.*;

class Solution {
    public long solution(long n) {

        char[] chars = String.valueOf(n).toCharArray();        
        
        // 오름차순 정렬 (char 배열은 reverseOrder를 쓸 수 없음)
        Arrays.sort(chars);       
        
        // 뒤집기 (
        StringBuilder sb = new StringBuilder(new String(chars));
        sb.reverse();        
        
        return Long.parseLong(sb.toString());
    }
}