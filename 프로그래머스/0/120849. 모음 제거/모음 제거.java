class Solution {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) == 'a' || my_string.charAt(i) == 'e'
            || my_string.charAt(i) == 'i' || my_string.charAt(i) == 'o'
            || my_string.charAt(i) == 'u') {
                continue;
            }else{
                builder.append(my_string.charAt(i));
            }
        }
        return builder.toString();
    }
}