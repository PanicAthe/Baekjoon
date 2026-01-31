import java.util.*;

class Solution
{
    public int solution(String s)
    {

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(sb.length()==0){
                
                sb.append(temp);
                
            }else if(sb.charAt(sb.length()-1)==temp){
                
                sb.delete(sb.length()-1, sb.length());
                
            }else{
                
                sb.append(temp);
            }
        }
        
        if(sb.length()==0){
            return 1;
        }

        return 0;
    }
}