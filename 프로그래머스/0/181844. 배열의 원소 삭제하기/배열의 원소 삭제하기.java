import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> listD = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        for(int i : delete_list) {
            listD.add(i);
        }
        for(int i : arr) {
            if(!listD.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}