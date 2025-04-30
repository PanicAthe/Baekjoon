import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                list.add(new int[]{i, rank[i]});
            }
        }

        list.sort((a, b) -> a[1] - b[1]); // 오름차순 정렬 (작은 rank 우선)

        int a = list.get(0)[0];
        int b = list.get(1)[0];
        int c = list.get(2)[0];

        return 10000 * a + 100 * b + c;
    }
}
