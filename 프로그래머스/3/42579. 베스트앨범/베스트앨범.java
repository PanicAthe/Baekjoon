import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 곡 정보와 총 재생 횟수 저장
        Map<String, List<int[]>> genreMap = new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();
        
        // 데이터 수집
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreMap.computeIfAbsent(genre, k -> new ArrayList<>())
                    .add(new int[]{i, play});
            playMap.merge(genre, play, Integer::sum);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        // 장르를 총 재생 횟수 내림차순으로 정렬
        playMap.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> {
                // 각 장르에서 재생 횟수 내림차순, 고유번호 오름차순으로 정렬 후 최대 2곡 선택
                genreMap.get(entry.getKey()).stream()
                    .sorted((a, b) -> {
                        if (b[1] != a[1]) return b[1] - a[1];  // 재생 횟수 내림차순
                        return a[0] - b[0];  // 고유 번호 오름차순
                    })
                    .limit(2)
                    .forEach(song -> answer.add(song[0]));
            });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}