class Solution {
    public String solution(String a, String b) {
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        String result = "";
        int cast = 0;
        while (a_index > -1 && b_index > -1) {
            int temp = a.charAt(a_index--) - '0';
            temp += b.charAt(b_index--) - '0';
            if (temp + cast < 10) {
                result += (temp + cast) + "";
            } else {
                result += (temp + cast) % 10 + "";
            }
            cast = (temp + cast) / 10;
        }

        if (a_index > -1) {
            while (a_index > -1) {
                int temp = a.charAt(a_index--) - '0';
                if (temp + cast < 10) {
                    result += (temp + cast) + "";
                } else {
                    result += (temp + cast) % 10 + "";
                }
                cast = (temp + cast) / 10;
            }
        } else if (b_index > -1) {
            while (b_index > -1) {
                int temp = b.charAt(b_index--) - '0';
                if (temp + cast < 10) {
                    result += (temp + cast) + "";
                } else {
                    result += (temp + cast) % 10 + "";
                }
                cast = (temp + cast) / 10;
            }
        }
        if(cast!=0){
            result+=cast+"";
        }
        String s = "";
        for (int i = result.length() - 1; i > -1; i--) {
            s += result.charAt(i);
        }
        return s;
    }
}