import java.util.Arrays;

class Solution {
    public int[] solution(String myString) {
        int[] list = Arrays.stream(myString.split("x"))
                .mapToInt(String::length).toArray();

        if(myString.charAt(myString.length()-1)=='x'){
            list = Arrays.copyOf(list,list.length + 1);
            list[list.length-1] = 0;
        }
        return list;
    }
}