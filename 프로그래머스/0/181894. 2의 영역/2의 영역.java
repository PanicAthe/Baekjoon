import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr)  
                .boxed()      
                .collect(Collectors.toList());  
        int start = list.indexOf(2);
        int end = list.lastIndexOf(2);
        if(start != -1 && end != -1) {
            return Arrays.stream(arr, start, end+1).toArray();
        }
        return new int[]{-1};
    }
}