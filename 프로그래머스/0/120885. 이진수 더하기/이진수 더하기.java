class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        int len1 = bin1.length()-1;
        int len2 = bin2.length()-1;
        int carry = 0;
        while(len1 >= 0 || len2 >= 0) {
            int n1 = 0;
            if(len1>=0){
                n1 = bin1.charAt(len1) - '0';
            }
            int n2 = 0;
            if(len2>=0){
                n2 = bin2.charAt(len2) - '0';
            }
            if(n1+n2>1){
                if(carry==1){
                    carry = 1;
                    answer += "1";
                }else{
                    carry = 1;
                    answer += "0";
                }
            }else{
                if(n1==1||n2==1){
                    if(carry==1){
                        carry = 1;
                        answer += "0";
                    }else{
                        answer += "1";
                    }
                }else{
                    if(carry==1){
                        answer += "1";
                        carry = 0;
                    }else{
                        answer += "0";
                    }
                }
            }
            len1--;
            len2--;
        }
        if(carry==1){
            answer += "1";
        }
        return new StringBuilder(answer).reverse().toString();
    }
}