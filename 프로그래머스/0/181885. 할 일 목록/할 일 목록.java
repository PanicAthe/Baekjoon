import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<String>();
        for(int i=0; i<todo_list.length; i++) {
            if(!finished[i]) {
                list.add(todo_list[i]);
            }
        }
        String[] result = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}