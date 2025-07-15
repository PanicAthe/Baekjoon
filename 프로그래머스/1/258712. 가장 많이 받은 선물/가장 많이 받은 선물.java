import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendMap = new HashMap<>();
        
        //친구 이름과 index를 매핑
        for(int i=0; i<friends.length; i++) {
            friendMap.put(friends[i], i);
        }

        // 서로 주고 받은 선물의 개수를 세기 위한 배열
        int[][] map = new int[friends.length][friends.length];
        // 선물 받은 횟수 기록
        int[] giftCount = new int[friends.length];
        // 선물을 준 횟수 기록
        int[] sentCount = new int[friends.length];

        for(String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            int giverIndex = friendMap.get(giver);
            int receiverIndex = friendMap.get(receiver);

            // 선물 주고 받은 횟수 기록
            map[giverIndex][receiverIndex]++;
            giftCount[receiverIndex]++;
            sentCount[giverIndex]++;
        }

        int[] result = new int[friends.length];
        // 다음달에 받을 선물 개수 예측
        for(int i=0; i<friends.length; i++) {
            for(int j=0; j<friends.length; j++) {
                if(i== j) continue;
                // i가 j에게 선물을 준 횟수가 j가 i에게 준 횟수보다 많으면
                if(map[i][j] > map[j][i]) {
                    result[i]++;
                }else if(map[i][j]<map[j][i]){
                    continue;
                }else if(sentCount[i]-giftCount[i] > sentCount[j] - giftCount[j]) {
                    // 선물 지수 비교
                    result[i]++;
                } 
            }
        }

        Arrays.sort(result);
        return result[result.length - 1]; 
    }
}