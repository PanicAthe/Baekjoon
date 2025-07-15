import java.util.Arrays;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        Arrays.sort(wallet);
        Arrays.sort(bill);

        // 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 
        // bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복        
        while(bill[0] > wallet[0] || bill[bill.length - 1] > wallet[wallet.length - 1]){

            //bill의 큰 값을 2로 나누고 나머지 버리기
            bill[bill.length - 1] /= 2;
            
            answer++;
            
            Arrays.sort(wallet);
            Arrays.sort(bill);
        }
        return answer;
    }
}