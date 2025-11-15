import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        int currentX = 0;
        int currentY = 0;
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++){
            char temp = dirs.charAt(i);
            String pre = currentX+","+currentY;
            
            if(temp=='U'){
                if(currentY<5){
                    currentY++;
                }
            }else if(temp=='D'){
                if(currentY>-5){
                    currentY--;
                }
            }else if(temp=='R'){
                if(currentX<5){
                    currentX++;
                }
            }else{
                if(currentX>-5){
                    currentX--;
                }
            }
            String cur = currentX+","+currentY;
            if(!cur.equals(pre)&&!set.contains(cur+"to"+pre)){
                set.add(pre+"to"+cur);
            }
        }
        
        return set.size();
    }
}