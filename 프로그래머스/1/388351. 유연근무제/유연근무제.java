class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i=0; i< schedules.length; i++){
            //희망시각
            int hour = schedules[i]/100;
            int min = schedules[i]%100 + 10; //10분 후
            if(min >= 60) {
                hour += min / 60;
                min = min % 60;
            }
            int curDay = startday; //시작 요일
            int count = 0;
            for(int j=0; j<7; j++){
                if(curDay>5){
                curDay = (curDay + 1) % 8 == 0 ? 1 : (curDay + 1) % 8;   // 다음 날로 넘어감
                    continue;
                }
                if(timelogs[i][j]/100<hour){ //희망 시간보다 일찍
                    count++;
                }else if(timelogs[i][j]/100==hour && timelogs[i][j]%100<=min){
                    count++;
                }
                curDay = (curDay + 1) % 8 == 0 ? 1 : (curDay + 1) % 8;   // 다음 날로 넘어감
            }
            if(count >= 5) {
                answer++;
            }   
        }
        return answer;
    }
}