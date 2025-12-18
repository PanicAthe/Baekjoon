import java.util.*;

class Solution {

    int maxLen;
    boolean[] want;
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> count = new HashMap<>();

    public void combi(String order, StringBuilder current, int index) {
        if (current.length() > maxLen || index > order.length()) {
            return;
        }

        if (want[current.length()]) {
            String key = current.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) > count.getOrDefault(key.length(), 0)) {
                count.put(key.length(), map.get(key));
            }
        }

        for (int i = index; i < order.length(); i++) {
            current.append(order.charAt(i));
            combi(order, current, i + 1);
            current.setLength(current.length() - 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {

        maxLen = course[course.length - 1];
        want = new boolean[21];
        for (int n : course) want[n] = true;

        for (String order : orders) {
            char[] temp = order.toCharArray();
            Arrays.sort(temp);
            combi(new String(temp), new StringBuilder(), 0);
        }

        ArrayList<String> list = new ArrayList<>();

        for (String entry : map.keySet()) {
            // 두명 이상 주문한 코스이고, 해당 코스 길의 최대값과 동일 할 때
            if (map.get(entry)>=2&&map.get(entry).equals(count.get(entry.length()))) {
                list.add(entry);
            }
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}
