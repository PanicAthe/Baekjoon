import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int sum = 0; //원하는 제품 수의 총합
        for(int i=0; i<number.length; i++){
            sum += number[i];
        }
        
        int count = 0;
        // 남은 세일 일자가 원하는 제품 수 총합보다 클 때만
        for(int i=0; i<=discount.length-sum; i++){
            // 세일 일자를 돌면서 
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=i; j<i+sum; j++){
                if(map.containsKey(discount[j])){
                    map.put(discount[j], map.get(discount[j])+1);
                }else{
                    map.put(discount[j], 1);
                }
            }
             // 만족하는지 확인
            boolean pass = true;
            for(int j=0; j<want.length; j++){
                if(!map.containsKey(want[j]) || map.get(want[j])<number[j]){ 
                    // 제품 할인이 아예 없거나 수량을 만족하지 않음
                    pass = false;
                    break;
                }
            }
            if(pass){
                count++;
            }
        }
        
        return count;
    }
}