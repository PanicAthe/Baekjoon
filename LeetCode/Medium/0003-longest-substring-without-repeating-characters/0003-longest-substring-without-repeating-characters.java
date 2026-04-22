import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> set = new HashMap<>();
            int cur = 0;
            for(int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if(set.containsKey(c)){
                    i = set.get(c) + 1;
                    break;
                }else{
                    cur++;
                    set.put(c, j);
                }
            }
            result = Math.max(result, cur);
        }
        return result;
    }
}