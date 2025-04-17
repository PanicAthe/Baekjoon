import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List list = new ArrayList<Integer>();
        for (String str : intStrs) {
            Integer temp = Integer.parseInt(str.substring(s, s + l));
            if (temp > k) {
                list.add(temp);
            }
        }
        return list.stream().mapToInt(i -> (int) i).toArray();
    }
}