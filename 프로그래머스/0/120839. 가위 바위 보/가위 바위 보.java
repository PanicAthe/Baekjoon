class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(int i=0; i<rsp.length(); i++){
            char temp = rsp.charAt(i);
            if(temp=='2'){
                answer += '0';
            }else if(temp=='0'){
                answer += '5';
            }else{
                answer += '2';
            }
        }
        return answer;
    }
}