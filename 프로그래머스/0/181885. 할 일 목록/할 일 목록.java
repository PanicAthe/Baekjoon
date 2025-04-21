import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        return Arrays.stream(todo_list)   // todo_list를 스트림으로 변환
                     .filter(i -> !finished[Arrays.asList(todo_list).indexOf(i)])  // finished[i]가 false인 것만 필터링
                     .toArray(String[]::new);   // 필터링된 결과를 String 배열로 변환
    }
}
