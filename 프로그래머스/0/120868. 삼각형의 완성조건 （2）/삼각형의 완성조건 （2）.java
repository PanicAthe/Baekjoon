import java.util.*;
class Solution {
    public int solution(int[] sides) {
        Set<Integer> set = new HashSet<>();
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        for(int i=max+1-min; i<=max;i++){
            set.add(i);
        }
        for(int i=max+1;i<max+min;i++){
            set.add(i);
        }
        return set.size();
    }
}