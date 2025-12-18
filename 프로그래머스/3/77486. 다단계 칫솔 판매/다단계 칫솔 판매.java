import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        
        HashMap<String, Integer> enrollMap = new HashMap<>();
        HashMap<String, String> referMap = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++){
            // 해쉬맵에 직원이름과 수익 저장.
            enrollMap.put(enroll[i], 0);
            
            // 해쉬맵에 직원이름과 referral 판매원 이름 저장
            referMap.put(enroll[i], referral[i]);
        }
        
        enrollMap.put("-", 0); //예외처리
        
        //한 판매원에게 이익이 생기면 10%를 떼어 referral 판매원에서 주기 
        //판매원 위에 referral이 없어질때까지 반복
        for(int i=0; i<seller.length; i++){
            String en = seller[i];
            int money = amount[i] * 100;
            
            while(!en.equals("-") && money>0){ 
                // referral 판매원에게 가야할 돈
                int referMoney = money*10/100;
                // 본인이 가져갈 돈
                money -= referMoney;
                // 본인의 이익에 더하기
                enrollMap.put(en, enrollMap.get(en)+money);
                // referral 판매원으로 
                en = referMap.get(en);
                money = referMoney;
            }
        }
        
        
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = enrollMap.get(enroll[i]);
        }
        return answer;
    }
}