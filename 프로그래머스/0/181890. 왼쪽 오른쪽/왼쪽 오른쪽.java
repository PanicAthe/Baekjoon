import java.util.Arrays;

class Solution {
    public String[] solution(String[] str_list) {
        for(int i=0; i<str_list.length; i++){
            if(str_list[i].equals("l")){
                return Arrays.stream(str_list, 0, i).toArray(String[]::new);
            }if(str_list[i].equals("r")){
                return Arrays.stream(str_list, i+1, str_list.length).toArray(String[]::new);
            }
        }
        return new String[]{};
    }
}