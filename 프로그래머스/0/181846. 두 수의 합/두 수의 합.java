import java.util.*;

class Solution {
    public String solution(String a, String b) {
        //뒷자리부터 올리면서 더하기 
        
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        
        int carry = 0;
        int digit = 0;
        
        StringBuilder sb = new StringBuilder("");
        
        while(a_index >= 0 || b_index >= 0){
            
            if(a_index >= 0){
                carry += a.charAt(a_index--) - '0';
            }
            
            if(b_index >= 0){
                carry += b.charAt(b_index--) - '0';
            }
            
            digit = carry % 10;
            carry = carry / 10;
            sb.append(digit);
        }
        if (carry > 0) {
            sb.append(carry);
        }

        sb.reverse();
        return sb.toString();
    }
}