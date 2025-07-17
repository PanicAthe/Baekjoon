class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] cur = new int[2];

        int w = park[0].length();
        int h = park.length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    cur[0] = i;
                    cur[1] = j;
                    break;
                }
            }
        }

        for(int i = 0; i < routes.length; i++){
            char direction = routes[i].charAt(0);
            int step = routes[i].charAt(2) - '0';

            boolean canMove = true;
            if(direction == 'E'){
                if(cur[1] + step < w ){
                    for(int j = 1; j <= step; j++){
                        if(park[cur[0]].charAt(cur[1]+j)=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) cur[1] += step;
                }
            }else if(direction == 'W'){
                if(cur[1] - step >= 0){
                    for(int j = 1; j <= step; j++){
                        if(park[cur[0]].charAt(cur[1]-j)=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) cur[1] -= step;
                }
            }else if(direction == 'S'){
                if(cur[0]+step < h){
                    for(int j = 1; j <= step; j++){
                        if(park[cur[0]+j].charAt(cur[1])=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) cur[0] += step;
                }
            }else if(direction == 'N'){
                if(cur[0] - step >= 0){
                    for(int j = 1; j <= step; j++){
                        if(park[cur[0]-j].charAt(cur[1])=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) cur[0] -= step;
                }
            }
        }
        return cur;
    }
}