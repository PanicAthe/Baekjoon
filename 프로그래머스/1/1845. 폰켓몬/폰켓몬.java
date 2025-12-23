import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);
        }
        
        if(set.size()>=nums.length/2){
            return nums.length/2;
        }
        
        return set.size();
    }
}