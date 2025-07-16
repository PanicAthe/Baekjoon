class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int attackIndex = 0;  // 현재 공격 인덱스
        int countSequence = 0; // 연속 회복 성공
        int maxHealth = health; // 최대 체력

        int lastTime = attacks[attacks.length - 1][0]; // 마지막 공격 시간
        for (int i = 1; i <= lastTime; i++) {
            if (attackIndex < attacks.length && attacks[attackIndex][0] == i) {
                // 공격받음
                health -= attacks[attackIndex][1];
                attackIndex++;
                countSequence = 0; // 연속 회복 초기화
                if (health <= 0) {
                    return -1;
                }
            } else {
                // 회복
                if (health < maxHealth) {
                    health += bandage[1];
                    health = Math.min(health, maxHealth);
                }
                countSequence++;
                if (countSequence >= bandage[0]) { // 연속 성공
                    health = Math.min(maxHealth, health + bandage[2]);
                    countSequence = 0; // 연속 초기화
                }
            }
        }
        return health;
    }
}