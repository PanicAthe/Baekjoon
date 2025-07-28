import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 유저이름과 인덱스 매핑
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
        }

        // 신고 중복 제거
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));

        //정지 유저 확인
        Map<String, Integer> reportCountMap = new HashMap<>();
        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String reported = parts[1];
            reportCountMap.put(reported, reportCountMap.getOrDefault(reported, 0) + 1);
        }

        //메일 발송
        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            if (reportCountMap.get(reported) >= k) {
                answer[idIndexMap.get(reporter)]++;
            }
        }

        return answer;
    }
}