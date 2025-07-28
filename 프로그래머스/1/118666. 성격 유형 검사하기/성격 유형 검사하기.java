import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[][]  types = {
            {"R", "T"},
            {"C", "F"},
            {"J", "M"},
            {"A", "N"}
        };
        Map<String, Integer> scoreMap = new java.util.HashMap<>();

        for(String[] type : types) {
            scoreMap.put(type[0], 0);
            scoreMap.put(type[1], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String type1 = survey[i].substring(0, 1);
            String type2 = survey[i].substring(1);
            int choice = choices[i];

            if (choice < 4) {
                scoreMap.put(type1, scoreMap.get(type1) + (4 - choice));
            } else if (choice > 4) {
                scoreMap.put(type2, scoreMap.get(type2) + (choice - 4));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String[] type : types) {
            String dominant = scoreMap.get(type[0]) >= scoreMap.get(type[1]) ? type[0] : type[1];
            sb.append(dominant);
        }

        return sb.toString();   
    }
}
