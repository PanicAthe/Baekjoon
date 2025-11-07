import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> result = new HashSet<Integer>();
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length;j++){
                result.add(numbers[i]+numbers[j]);
            }
        }    
        
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}