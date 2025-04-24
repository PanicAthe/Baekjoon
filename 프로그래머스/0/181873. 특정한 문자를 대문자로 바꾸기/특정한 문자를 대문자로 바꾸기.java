class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        char al = alp.charAt(0);
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(al==c){
                answer += (char)(al-32);
            }else{
                answer += c;
            }
        }
        return answer;
    }
}