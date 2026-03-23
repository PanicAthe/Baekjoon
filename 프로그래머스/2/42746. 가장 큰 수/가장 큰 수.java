import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        numbers = Arrays.stream(numbers)
        .boxed()
        .sorted((a,b)->{
            String A = String.valueOf(a);
            String B = String.valueOf(b);
            
            // A+B vs B+A 비교해서 더 큰 쪽이 앞에 오도록
            // 3, 30 → "330" vs "303" → "330"이 더 크므로 3이 앞
            return (B + A).compareTo(A + B);
        })        
        .mapToInt(Integer::intValue)
        .toArray();
        
        // 제일 큰 숫자가 0이면 바로 0 리턴
        if (numbers[0] == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : numbers) {
            sb.append(num);
        }

        return sb.toString();
    }
}