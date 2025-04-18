class Solution {
    public int solution(String my_string, String is_prefix) {
        int pr = is_prefix.length();
        if(my_string.length()<pr){
            return 0;
        }else{
            return (my_string.substring(0,pr).equals(is_prefix))? 1 : 0;
        }
    }
}