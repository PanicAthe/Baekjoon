import java.util.Arrays;
class Solution {
    static int width;
    static int height;
    static String[][] map;
    public int solution(int[] mats, String[][] park) {
        map = park;
        width = park[0].length;
        height = park.length;

        Arrays.sort(mats);

        for(int i=mats.length-1; i>-1; i--) {
            for(int j=0; j<width; j++) {
                for(int k=0; k<height; k++) {
                    if(!map[k][j].equals("-1")) {
                        continue;
                    }
                    if(isValid(k, j, mats[i])) {
                        return mats[i];
                    }
                }   
            }
        }
        
        return -1;
    }

    public boolean isValid(int x, int y, int size) {
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(i<0 || i>=height || j<0 || j>=width || !map[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}