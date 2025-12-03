import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        StringBuilder answer = new StringBuilder();
        Stack<Integer> deleted = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i=0; i<n; i++){
            prev[i] = i-1;
            next[i] = i+1;
            answer.append("O");
        }
        prev[0] = -1;
        next[n-1] = -1;
        
        for(int i=0; i<cmd.length; i++){
            String[] commands = cmd[i].split(" ");
            if(commands[0].equals("C")){
                // 행 삭제
                answer.setCharAt(k, 'X');
                // 삭제된 행 스택에 넣기
                deleted.push(k);

                int tempNext = next[k];
                int tempPrev = prev[k];
                if(tempNext == -1){ 
                    //삭제된 행이 가장 마지막 행, 바로 윗 행을 선택
                    k = tempPrev;
                    // 삭제된 행의 앞 행은 마지막 행으로 표시
                    next[tempPrev] = -1;
                }else{
                    // 삭제된 행의 아래 행을 선택
                    k = tempNext;
                    // 삭제된 행 앞 뒤 연결
                    prev[tempNext] = tempPrev;
                    if (tempPrev != -1) {
                        next[tempPrev] = tempNext;
                    }
                }
                
            }else if(commands[0].equals("Z")){
                // 가장 최근 삭제된 행 복구
                int restore = deleted.pop();
                answer.setCharAt(restore, 'O');
                
                //앞 뒤 다시 연결 시키기
                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
                
            }else{
                int count = Integer.parseInt(commands[1]);
                if(commands[0].equals("U")){
                    for(int j=0; j<count; j++){
                        k = prev[k];
                    }
                }else{
                    for(int j=0; j<count; j++){
                        k = next[k];
                    }
                }
            }
            
        }
        
        return answer.toString();
    }
}