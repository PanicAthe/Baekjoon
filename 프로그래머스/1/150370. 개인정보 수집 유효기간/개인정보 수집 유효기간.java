import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            map.put(terms[i].substring(0,1), Integer.parseInt(terms[i].substring(2)));
        }
        int [] to = new int[3];
        to[0] = Integer.parseInt(today.substring(0,4));
        to[1] = Integer.parseInt(today.substring(5,7));
        to[2] = Integer.parseInt(today.substring(8));
        int [] date = new int[3];

        for(int i=0; i<privacies.length; i++) {
            date[0] = Integer.parseInt(privacies[i].substring(0,4));
            date[1] = Integer.parseInt(privacies[i].substring(5,7));
            date[2] = Integer.parseInt(privacies[i].substring(8,10));
            String s = privacies[i].substring(11);
            int month = map.get(s);

            date[1] += month;
            while (date[1] > 12) {
                date[0]++;
                date[1] -= 12;
            }

            if(date[0]>to[0]){
                continue;
            }else if(date[0]==to[0]&&date[1]>to[1]){
                continue;
            }else if(date[0]==to[0]&&date[1]==to[1]&&date[2]>to[2]){
                continue;
            }

            list.add(i+1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}