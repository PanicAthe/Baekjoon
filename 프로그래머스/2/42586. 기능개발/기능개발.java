import java.util.*; 

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> count = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            int day = 100 - progresses[i];
            day = (day%speeds[i]>0)? day/speeds[i]+1 : day/speeds[i];
            
            if(dq.isEmpty()||dq.peekLast()<day){
                dq.addLast(day);
                count.addLast(1);
            }else{
                int temp = count.pollLast();
                count.addLast(temp+1);
            }
        }
               
        return count.stream().mapToInt(Integer::intValue).toArray();
    }
}