import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < myStr.length(); i++) {
            char c = myStr.charAt(i);
            if (c == 'a' || c == 'b' || c == 'c') {
                if (temp.length() > 0) {
                    list.add(temp.toString());
                    temp.setLength(0); 
                }
            } else {
                temp.append(c);
            }
        }

        if (temp.length() > 0) {
            list.add(temp.toString());
        }

        if (!list.isEmpty()) {
            return list.toArray(new String[0]);
        } else {
            return new String[] { "EMPTY" };
        }
    }
}
