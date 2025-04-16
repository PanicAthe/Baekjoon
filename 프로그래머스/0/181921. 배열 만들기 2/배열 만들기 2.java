import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int l, int r) {
        Queue<Integer> q = new LinkedList<>();

        Queue<String> q2 = new LinkedList<>();
        q2.add("5");
        while (!q2.isEmpty()) {
            String s = q2.poll();
            if (Integer.parseInt(s) >= l) {
                q.add(Integer.parseInt(s));
            }
            if (Integer.parseInt(s + "0") <= r) {
                q2.add(s + "0");
            }
            if (Integer.parseInt(s + "5") <= r) {
                q2.add(s + "5");
            }

        }
        if (q.size() == 0) return new int[]{-1};
        return q.stream().mapToInt(i -> i).toArray();
    }


}