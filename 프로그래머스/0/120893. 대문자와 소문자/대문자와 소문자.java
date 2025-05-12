class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length();i++){
            char temp = my_string.charAt(i);
            if(temp>='a'&&temp<='z'){
                temp = (char)(temp-32);
            }else{
                temp = (char)(temp+32);
            }
            answer+=temp;
        }
        return answer;
    }
}