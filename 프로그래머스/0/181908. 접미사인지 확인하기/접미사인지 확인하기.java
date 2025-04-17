class Solution {
    public int solution(String my_string, String is_suffix) {
        int my = my_string.length();
        int su = is_suffix.length();
        if (my>=su&&my_string.substring(my - su, my).equals(is_suffix)) {
            return 1;
        }
        return 0;
    }
}