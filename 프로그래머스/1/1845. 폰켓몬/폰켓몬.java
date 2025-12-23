import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));       
        return Math.min(nums.length/2, set.size());
    }
}