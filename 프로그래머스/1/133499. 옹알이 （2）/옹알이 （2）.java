class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] validWords = {"aya", "ye", "woo", "ma"};

        for(String word : babbling) {
            int preIndex = -1; //사용했던 발음 인덱스
            boolean ok = true;
            while(word.length() > 0) {
                boolean found = false;
                
                // 가능한 발음으로 시작하는지 검사
                for(int i=0; i < validWords.length; i++) { 
                    if(word.startsWith(validWords[i]) && i!= preIndex) {
                        preIndex = i;
                        word = word.substring(validWords[i].length());
                        found = true;
                        break;
                    }
                }
                if(!found) { // 발음이 불가능한 문자열
                    ok = false;
                    break;
                }
            }

            if(ok) {
                answer++;
            }
        }

        return answer;
    }
}