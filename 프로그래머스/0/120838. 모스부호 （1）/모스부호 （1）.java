import java.util.HashMap;

class Solution {
    public String solution(String letter) {
        HashMap<String, Character> map = new HashMap<>();
        String[] letters = letter.split(" ");
        String[] arr1 = {
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],(char)('a'+i));
        }
        String result = "";
        for (String arg : letters) {
            result += map.get(arg);
        }
        return result;
    }
}