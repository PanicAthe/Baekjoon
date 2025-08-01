class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10; //*
        int right = 12; //# 
        
        for(int i=0; i<numbers.length; i++){
            int n = numbers[i];
            if(n==0) n = 11; // 0을 11로

            if(n==1||n==4||n==7){
                left = n; // 왼손
                answer += "L";
                continue;
            }
            
             if(n==3||n==6||n==9){
                right = n; // 오른손
                answer += "R";
                continue;
            }

            int leftDistance = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
            int rightDistance = Math.abs(n - right) / 3 + Math.abs(n - right) % 3;      
            if(leftDistance < rightDistance){
                left = n; // 왼손
                answer += "L";
            } else if(leftDistance > rightDistance){
                right = n; // 오른손
                answer += "R";
            } else {
                if(hand.equals("left")){
                    left = n; // 왼손
                    answer += "L";
                } else {
                    right = n; // 오른손
                    answer += "R";
                }   
            }
        }            
        return answer;
    }
}