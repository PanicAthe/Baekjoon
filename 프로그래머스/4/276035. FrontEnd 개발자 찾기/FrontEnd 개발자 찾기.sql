-- Front End 스킬을 가진 개발자 조회
-- SKILL_CODE 컬럼은 비트마스크 형태로 스킬을 저장
-- 각 bit는 SKILLCODES.CODE 값과 매칭됨
-- 비트 AND 연산(&)으로 특정 스킬 보유 여부 확인 가능
-- D.SKILL_CODE & S.CODE != 0 → 개발자가 해당 스킬을 가지고 있음

SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
JOIN SKILLCODES S
  ON (D.SKILL_CODE & S.CODE) != 0 
WHERE S.CATEGORY = 'Front End'     
ORDER BY D.ID;