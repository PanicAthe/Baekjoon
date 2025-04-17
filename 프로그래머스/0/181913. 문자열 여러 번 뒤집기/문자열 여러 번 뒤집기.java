class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int i=0; i<queries.length; i++){
            my_string = reverse(my_string.toCharArray(), queries[i][0], queries[i][1]);
        }
        return my_string;
    }

    String reverse(char[] str, int s, int e){

        while(s<=e){
            char temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s++;
            e--;
        }
        return new String(str);
    }
}