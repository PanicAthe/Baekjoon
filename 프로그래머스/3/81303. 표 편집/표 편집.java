import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        // 삭제된 index 쌓아둘 스택
        Stack<Integer> stack = new Stack<>();
        
        char[] result = new char[n];
        // 각 행의 다음 행 저장.
        int[] next = new int[n];
        // 각 행의 직전 행 저장.
        int[] prev = new int[n];
        
        // up은 앞으로 <-
        for(int i=0; i<n; i++){
            result[i] = 'O';
            next[i] = i+1;
            prev[i] = i-1;
        }
        
        // 각 명령어 실행
        for(int i=0; i<cmd.length; i++){
            String command = cmd[i];
            
            if(command.length()==1){
                if(command.equals("C")){
                    // 현재 선택된 행 삭제하기.
                    stack.push(k);
                    result[k] = 'X';
                    
                    if(prev[k]==-1){
                        //선택된 행이 천장
                        prev[next[k]] = prev[k];
                        k = next[k];
                        
                    }else if(next[k]==n){
                        //선택된 행이 바닥
                        next[prev[k]] = next[k];
                        // 바로 윗행 선택
                        k = prev[k];
                        
                    }else{
                        next[prev[k]] = next[k];
                        prev[next[k]] = prev[k];
                        k = next[k];
                    }                  
                    
                }else{
                    // 가장 최근에 삭제된 행 복구하기
                    // 현재 선택된 행을 바뀌지 않음
                    int tempK = stack.pop();
                    result[tempK] = 'O';
                    
                    if(prev[tempK]==-1){
                        //선택된 행이 천장
                        prev[next[tempK]] = tempK;
                        
                    }else if(next[tempK]==n){
                        //선택된 행이 바닥
                        next[prev[tempK]] = tempK;
                        
                    }else{
                        next[prev[tempK]] = tempK;
                        prev[next[tempK]] = tempK;
                    }
                }
            }else{
                String[] arr = command.split(" ");
                int x = Integer.parseInt(arr[1]);
                
                if(command.charAt(0)=='U'){
                    //현재 선택된 행에서 X칸 위에 있는 행 선택
                    for(int j=0; j<x; j++){
                        k = prev[k];
                    }
                }else{
                    // 현재 선택된 행에서 X칸 아래에 있는 행 선택
                    for(int j=0; j<x; j++){
                        k = next[k];
                    }
                }
            }
        }
        
        return new String(result);
    }
}