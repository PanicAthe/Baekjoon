class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        //전부 초단위로
        //현재 위치
        int curSec = Integer.parseInt(pos.substring(0, 2)) * 60 + Integer.parseInt(pos.substring(3, 5));
        // 오프닝 시작 위치
        int opStartSec = Integer.parseInt(op_start.substring(0, 2)) * 60 + Integer.parseInt(op_start.substring(3, 5));
        // 오프닝 종료 위치
        int opEndSec = Integer.parseInt(op_end.substring(0, 2)) *   60 + Integer.parseInt(op_end.substring(3, 5));
        // 비디오 길이
        int videoLenSec = Integer.parseInt(video_len.substring(0, 2)) * 60 + Integer.parseInt(video_len.substring(3, 5));

        // 오프닝 구간에 있는 자동으로 끝나는 위치로
        if (curSec >= opStartSec && curSec < opEndSec) {
            curSec = opEndSec;
        }
        
        for(int i=0; i<commands.length; i++) {

            if (commands[i].equals("next")) {
                curSec += 10;
                if (curSec > videoLenSec) curSec = videoLenSec;
            } else if (commands[i].equals("prev")) {
                curSec -= 10;
                if (curSec < 0) curSec = 0;
            }

            // 오프닝 구간에 있는 자동으로 끝나는 위치로
            if (curSec >= opStartSec && curSec < opEndSec) {
                curSec = opEndSec;
            }
        }

        return String.format("%02d:%02d", curSec / 60, curSec % 60);
    }
}