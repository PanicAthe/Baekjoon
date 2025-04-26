class Solution {
    public int solution(String binomial) {
        String[] s = binomial.split("\\s");
        if(s[1].equals("+")) {
            return Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
        }else if(s[1].equals("-")) {
            return Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
        }
        return Integer.parseInt(s[0]) * Integer.parseInt(s[2]);
    }
}