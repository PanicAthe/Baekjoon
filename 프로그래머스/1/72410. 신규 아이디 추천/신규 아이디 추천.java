class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계 모두 소문자로
        answer = new_id.toLowerCase(); 
        
        //2단계 특수문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", ""); 
       
        //3단계 연속된 마침표 제거
        answer = answer.replaceAll("\\.{2,}", "."); 
        
        //4단계 마침표가 처음이나 끝에 있으면 제거
        answer = answer.replaceAll("^\\.|\\.$", ""); 
       
        //5단계 빈 문자열이면 "a" 대입
        if (answer.isEmpty()) {
            answer = "a"; 
        }
       
        //6단계 길이가 16자 이상이면 15자로 줄이고 마지막 마침표 제거
        answer = answer.substring(0, Math.min(answer.length(), 15)); 
        
        //마지막 문자가 마침표면 제거
        answer = answer.replaceAll("\\.$", ""); 

        //7단계 길이가 2자 이하이면 마지막 문자를 반복하여 3자로 만듦
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}