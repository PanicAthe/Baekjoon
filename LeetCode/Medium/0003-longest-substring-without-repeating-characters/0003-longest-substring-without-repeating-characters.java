import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            int cur = 0;
            for(int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if(set.contains(c)){
                    break;
                }else{
                    cur++;
                    set.add(c);
                }
            }
            result = Math.max(result, cur);
        }
        return result;
    }
}