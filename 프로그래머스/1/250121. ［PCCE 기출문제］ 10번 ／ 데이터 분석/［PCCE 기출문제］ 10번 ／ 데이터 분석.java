import java.util.Arrays;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        final int extIndex;
        final int sortIndex;
        if(ext.equals("code")){
            extIndex = 0;
        } else if(ext.equals("date")) {
            extIndex = 1;
        } else if(ext.equals("maximum")) {
            extIndex = 2;
        } else {
            extIndex = 3;
        }
        if(sort_by.equals("code")){
            sortIndex = 0;
        }else if(sort_by.equals("date")) {
            sortIndex = 1;
        } else if(sort_by.equals("maximum")) {
            sortIndex = 2;
        } else {
            sortIndex = 3;
        }

        data = Arrays.stream(data)
                .filter(row -> row[extIndex] < val_ext)
                .sorted((a, b) -> Integer.compare(a[sortIndex], b[sortIndex]))
                .toArray(int[][]::new);

        return data;
    }
}