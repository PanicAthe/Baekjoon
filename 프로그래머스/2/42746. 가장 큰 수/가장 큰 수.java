import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        numbers = Arrays.stream(numbers)
            .boxed()
            .sorted((a,b)->{
                String x = String.valueOf(a);
                String y = String.valueOf(b);
                
                // 내림차순
                return Integer.parseInt(y+x) - Integer.parseInt(x+y);
            })
            .mapToInt(Integer::intValue)
            .toArray();
        
        if(numbers[0]==0) return "0";
        
        String answer = "";
        for(int i=0; i<numbers.length; i++){
            answer += numbers[i];
        }
        return answer;
    }
}