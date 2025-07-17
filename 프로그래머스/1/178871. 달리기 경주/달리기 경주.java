import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndex = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++) {
            int index = playerIndex.get(callings[i]); // 이름 불린 선수 위치
            String player2 = players[index-1]; // 뒤쳐진 플레이어 이름
            players[index-1] = callings[i]; 
            players[index] = player2;

            //순위 다시 저장
            playerIndex.remove(callings[i]);
            playerIndex.remove(player2);
            playerIndex.put(callings[i], index-1);
            playerIndex.put(player2, index);

        }

        return players;
    }
}
