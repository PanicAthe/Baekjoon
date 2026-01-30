import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
            .boxed()
            .sorted((a,b)->{
            int diffA = Math.abs(a-n);
            int diffB = Math.abs(b-n);
            if(diffA == diffB){
                // 더 큰 수가 먼저
                return b - a;
            }else{
                // n과 가까운 수가 먼저
                return diffA - diffB;
            }
        }).mapToInt(i->i).toArray();
    }
}
