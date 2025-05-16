class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            boolean isMatch = true;
            for (String s : spell) {
                if (!word.contains(s)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) return 1;
        }
        return 2;
    }
}
