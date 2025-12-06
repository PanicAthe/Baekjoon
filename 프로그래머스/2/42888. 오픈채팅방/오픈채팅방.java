import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        // 기록을 보고 닉네임 확정
        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            
            // 닉네임이 설정은 두가지 방법으로
            if(temp[0].equals("Enter") || temp[0].equals("Change")) {
               map.put(temp[1], temp[2]); // uid와 닉네임 등록
            }
            
            // result에 반영
            if(temp[0].equals("Enter")) {
                result.add(temp[1]+" 님이 들어왔습니다.");
            }
            if(temp[0].equals("Leave")){
                result.add(temp[1]+" 님이 나갔습니다.");
            }
        }
        
        String[] answer = result.toArray(new String[0]);
        for(int i=0; i<answer.length; i++){
            String[] temp = answer[i].split(" ");
            answer[i] = answer[i].replace(temp[0], map.get(temp[0]));
            answer[i] = answer[i].replace(" 님이", "님이");

        }
        
        return answer;
    }
}