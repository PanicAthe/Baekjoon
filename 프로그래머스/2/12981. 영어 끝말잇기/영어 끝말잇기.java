import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        // 사용된 단어 셋
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        char c = words[0].charAt(words[0].length()-1);
        
        for(int i=1; i<words.length; i++){
            String word = words[i];
            // 처음 말하는 단어이고, 첫 알파벳이 앞 단어의 마지막 알파벳
            if(!set.contains(word) && word.charAt(0)==c){
                // 사용된 단어 셋에 추가
                set.add(word);
                // 마지막 알파벳 업데이트
                c = word.charAt(word.length()-1);
            }else{              
                // 몇 번째 단어였는지
                int count = i + 1;
                // 탈락자 번호
                answer[0] = (count%n==0)? n : count%n;
                // 탈락자에게 몇 번째 차례 였는지
                answer[1] = (count%n==0)? count/n : count/n+1;
                break;
            }    
        }       

        return answer;
    }
}