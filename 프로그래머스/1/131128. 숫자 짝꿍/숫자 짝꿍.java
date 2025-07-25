class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            yCount[Y.charAt(i) - '0']++;
        }  
        
        for (int i = 9; i >= 0; i--) {
            int minCount = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < minCount; j++) {
                answer.append(i);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        } else if (answer.toString().replaceAll("0", "").isEmpty()) {
            return "0";
        }

        return answer.toString();
    }
}
